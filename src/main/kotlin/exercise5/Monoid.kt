package exercise5

class Monoid<T : Any>(private val initial: T, private val operation: (T, T) -> T) {
    fun Collection<T>.fold(): T = this.fold(initial, operation)
}