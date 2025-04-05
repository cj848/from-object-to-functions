package exercise5

class Monoid<T : Any>(val initial: T, val operation: (T, T) -> T) {
    fun Collection<T>.fold(): T = this.fold(initial, operation)
}