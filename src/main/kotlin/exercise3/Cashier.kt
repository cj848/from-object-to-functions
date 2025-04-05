package exercise3

import kotlin.math.floor

enum class Item { carrot, milk }

class Cashier {
    lateinit var prices: Map<Item, Double>
    private val actorNameItemQuantities = mutableMapOf<String, MutableMap<Item, Int>>()
    private var discount3x2: Item? = null
    fun setupPrices(prices: Map<Item, Double>) {
        this.prices = prices
    }

    fun totalFor(actorName: String): Double {
        return actorNameItemQuantities[actorName]?.let {
            it.asSequence()
                .map { (key, value) ->
                    val newValue = value.takeIf { discount3x2 == key }
                        ?.let { it - floor(it / 3f).toDouble() }
                        ?: value.toDouble()
                    prices[key]!!.toDouble() * newValue
                }.sum()
        } ?: 0.0
    }

    fun addItems(actorName: String, qty: Int, item: Item) {
        val actorItemQuantities = actorNameItemQuantities[actorName] ?: mutableMapOf()
        actorNameItemQuantities[actorName] = actorItemQuantities
        actorItemQuantities[item] = actorItemQuantities.getOrDefault(item, 0) + qty
    }

    fun setup3x2(item: Item) {
        discount3x2 = item
    }

    fun clear() {
        actorNameItemQuantities.clear()
        discount3x2 = null
    }
}