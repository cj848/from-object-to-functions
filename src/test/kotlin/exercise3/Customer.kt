package exercise3

import com.ubertob.pesticide.core.DdtActor
import strikt.api.expectThat
import strikt.assertions.isEqualTo

data class Customer(override val name: String) : DdtActor<CashierActions>() {
    fun `can add #qty #item`(qty: Int, item: Item) = step(qty, item) {
        addItems(name, qty, item)
    }

    fun `check total is #total`(expected: Double) = step(expected) {
        expectThat(totalFor(name)).isEqualTo(expected)
    }
}