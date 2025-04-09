package exercise5

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FibonacciTest {
    @Test
    fun fibonacci() {
        expectThat(fibonacci(0)).isEqualTo(0)
        expectThat(fibonacci(1)).isEqualTo(1)
        expectThat(fibonacci(2)).isEqualTo(1)
        expectThat(fibonacci(3)).isEqualTo(2)
        expectThat(fibonacci(4)).isEqualTo(3)
        expectThat(fibonacci(5)).isEqualTo(5)
        expectThat(fibonacci(6)).isEqualTo(8)
        expectThat(fibonacci(7)).isEqualTo(13)
    }
}