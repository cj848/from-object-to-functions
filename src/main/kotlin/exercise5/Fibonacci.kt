package exercise5

fun fibonacci(n: Int): Int {
    return fibonacci(n, 0, 1)
}

tailrec fun fibonacci(n: Int, a: Int, b: Int): Int {
    return if (n == 0) a else fibonacci(n - 1, b, a + b)
}