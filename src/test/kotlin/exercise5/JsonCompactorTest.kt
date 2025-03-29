package exercise5

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class JsonCompactorTest {
    @Test
    fun test() {
        val json = """{ "my greetings" : "hello world! \"How are you?\"" }"""
        val expected = """{"my greetings":"hello world! \"How are you?\""}"""
        expectThat(compactJson(json)).isEqualTo(expected)
    }
}