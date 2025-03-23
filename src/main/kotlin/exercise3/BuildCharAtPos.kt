package exercise3

fun buildCharAtPos(s: String): (Int) -> Char = { idx ->
    (idx in s.indices).takeIf { it }?.let { s[idx]} ?: error("Index out of bounds")
}