package exercise4

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class CurryTest {
    @Test
    fun execircise4_3_1() {
        val plus3Fn = ::sum.curry()(3)
        expectThat(plus3Fn(4)).isEqualTo(7)

        val starPrefixFn = ::strConcat.curry()("*")
        expectThat(starPrefixFn("abc")).isEqualTo("* abc")
    }

    @Test
    fun exercise4_3_2() {
        val curriedConcat = ::strConcat.curry()

        expectThat(curriedConcat `+++` "head" `+++` "tail").isEqualTo("head tail")

        val curriedSum = ::sum.curry()
        expectThat(curriedSum `+++` 4 `+++` 5).isEqualTo(9)
    }
}