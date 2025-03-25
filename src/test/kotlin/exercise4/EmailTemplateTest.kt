package exercise4

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class EmailTemplateTest {
    @Test
    fun emailTemplate() {
        val expected = """Hello 강현식
                |Your email is cj848@hanmail.net
            """.trimMargin()
        val template = EmailTemplate(
            """
            Hello {name}
            Your email is {email}
        """.trimIndent()
        )
        expectThat(
            template(Person(name = "강현식", email = "cj848@hanmail.net"))
        )
            .isEqualTo(expected)
    }
}