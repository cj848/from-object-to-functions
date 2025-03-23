package exercise2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RpnCalculatorTest {
    @Test
    fun rpcTest() {
        val calc = RpnCalculator()

        assertEquals(9.toBigDecimal(), calc.calc("4 5 +"))
        assertEquals(3.toBigDecimal(), calc.calc("6 2 /"))
        assertEquals(10.toBigDecimal(), calc.calc("5 6 2 1 + / *"))
        assertEquals(2.toBigDecimal(), calc.calc("2 5 * 4 + 3 2 * 1 + /"))
    }
}