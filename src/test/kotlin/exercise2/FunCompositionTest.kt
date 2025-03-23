package exercise2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FunCompositionTest {
    @Test
    fun testComposition() {
        val add2 = { a: Int -> a + 2 }
        val mul3 = { a: Int -> a * 3 }
        val add2AndMul3 = add2 andThen mul3

        assertEquals(15, add2AndMul3(3))
    }
}