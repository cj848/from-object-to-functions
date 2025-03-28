package exercise5

fun Int.collatz() = collatzR(listOf(), this)

tailrec fun collatzR(acc: List<Int>, x: Int): List<Int> {
    return if (x <= 1) acc + listOf(x) else {
        val element = if (x % 2 == 0) {
            x / 2
        } else {
            x * 3 + 1
        }
        collatzR(acc + listOf(x), element)
    }
}