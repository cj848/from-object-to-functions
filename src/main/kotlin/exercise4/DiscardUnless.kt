package exercise4

import exercise2.FUN
import java.time.LocalDate

fun <T> T.discardUnless(predicate: T.() -> Boolean): T? = if (predicate(this)) this else null

infix fun <A : Any, B : Any, C : Any> FUN<A, B?>.andUnlessNull(other: FUN<B, C?>): FUN<A, C?> = { a ->
    this(a)?.run { other(this) }
}

data class ToDoItem(
    val description: String,
    val dueDate: LocalDate? = null,
    val status: ToDoStatus = ToDoStatus.Todo
)

enum class ToDoStatus { Todo, InProgress, Done, Blocked }