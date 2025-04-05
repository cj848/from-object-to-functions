package exercise4

import exercise3.renderTemplate
import exercise3.tag

data class Person(
    val name: String,
    val email: String
)

class EmailTemplate(private val templateText: String) : (Person) -> String? {
    override fun invoke(aPerson: Person): String? {
        return renderTemplate(templateText, mapOf("name" tag aPerson.name, "email" tag aPerson.email))
    }
}