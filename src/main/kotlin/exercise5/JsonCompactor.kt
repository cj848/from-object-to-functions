package exercise5

sealed class JsonCompactor {
    abstract val jsonCompacted: String
    abstract fun compact(c: Char): JsonCompactor
}

data class InQuotes(override val jsonCompacted: String) : JsonCompactor() {
    override fun compact(c: Char): JsonCompactor = when {
        c == '\\' -> Escaped(jsonCompacted + c)
        c == '"' -> OutQuotes(jsonCompacted + c)
        else -> InQuotes(jsonCompacted + c)
    }
}

data class OutQuotes(
    override val jsonCompacted: String
) : JsonCompactor() {
    override fun compact(c: Char): JsonCompactor = when {
        c.isWhitespace() -> this
        c == '"' -> InQuotes(jsonCompacted + c)
        else -> OutQuotes(jsonCompacted + c)
    }
}

data class Escaped(override val jsonCompacted: String) : JsonCompactor() {
    override fun compact(c: Char): JsonCompactor {
        return InQuotes(jsonCompacted + c)
    }
}

fun compactJson(input: String): String {
    val compacted: JsonCompactor = OutQuotes("")
    return input.fold(compacted) { acc, c ->
        acc.compact(c)
    }.jsonCompacted
}