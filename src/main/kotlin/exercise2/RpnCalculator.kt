package exercise2

import java.math.BigDecimal

class RpnCalculator {
    val operationMap = mapOf(
        "+" to BigDecimal::plus,
        "-" to BigDecimal::minus,
        "*" to BigDecimal::multiply,
        "/" to BigDecimal::divide
    )
    fun calc(expr: String): BigDecimal {
        val stack = FunStack<BigDecimal>()
        return expr.split(" ").fold(stack) { acc, token ->
            token.toBigDecimalOrNull()?.run { acc.push(this) }
                ?: operationMap[token]?.run {
                    val (b, stack1) = acc.pop()
                    val (a, stack2) = stack1.pop()
                    stack2.push(this(a, b))
                }
                ?: throw IllegalArgumentException("Unknown token $token")
        }.pop().first
    }
}