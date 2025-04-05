package exercise5

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class MonoidTest {
    @Test
    fun intPlus() {
        with(Monoid(0, Int::plus)) {
            expectThat(listOf(1, 2, 3, 4, 10).fold()).isEqualTo(20)
        }
    }

    @Test
    fun stringPlus() {
        with(Monoid("", String::plus)) {
            expectThat(listOf("My", "Fair", "Lady").fold()).isEqualTo("MyFairLady")
        }
    }

    private val zeroMoney = Money(0.0)
    data class Money(val amount: Double) {
        fun sum(other: Money) = Money(amount + other.amount)
    }

    @Test
    fun moneySum() {
        with(Monoid(zeroMoney, Money::sum)) {
            expectThat(listOf(
                Money(2.1),
                Money(3.9),
                Money(4.0),
            ).fold()).isEqualTo(Money(10.0))
        }
    }
}