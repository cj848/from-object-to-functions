package exercise3

import com.ubertob.pesticide.core.*
import exercise3.Item.carrot
import exercise3.Item.milk

typealias CasherDDT = DomainDrivenTest<CashierActions>

class CashierDomainActions() : CashierActions {
    private val casher = Cashier()
    override fun setupPrices(prices: Map<Item, Double>) {
        casher.setupPrices(prices)
    }

    override fun totalFor(actorName: String): Double {
        return casher.totalFor(actorName)
    }

    override fun addItems(actorName: String, qty: Int, item: Item) {
        casher.addItems(actorName, qty, item)
    }

    override fun setup3x2(item: Item) {
        casher.setup3x2(item)
    }

    override val protocol: DdtProtocol
        get() = DomainOnly

    override fun prepare() = Ready
}

val allActions = setOf<CashierActions>(CashierDomainActions())

class CashierDDT : CasherDDT(allActions) {
    val alice by NamedActor(::Customer)

    @DDT
    fun `customer can buy an item`() = ddtScenario {
        val prices = mapOf(carrot to 2.0, milk to 5.0)
        setUp {
            setupPrices(prices)
        }.thenPlay(
            alice.`can add #qty #item`(3, carrot),
            alice.`can add #qty #item`(1, milk),
            alice.`check total is #total`(11.0)
        )
    }

    @DDT
    fun `customer can benefit from 3x2 offer()`() = ddtScenario {
        val prices = mapOf(carrot to 2.0, milk to 5.0)
        setUp {
            setupPrices(prices)
            setup3x2(milk)
        }.thenPlay(
            alice.`can add #qty #item`(3, carrot),
            alice.`can add #qty #item`(3, milk),
            alice.`can add #qty #item`(5, milk),
            alice.`check total is #total`(36.0)
        )
    }
}