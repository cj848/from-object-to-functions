package exercise4

fun sum(num1: Int, num2: Int) = num1 + num2
fun strConcat(s1: String, s2: String) = "$s1 $s2"

fun <A, B, C> ((A, B) -> C).curry(): (A) -> (B) -> (C) = { a ->
    { b -> this(a, b) }
}

infix fun <A, B> ((A) -> B).`+++`(a: A): B = this(a)