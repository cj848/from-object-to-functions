package exercise4

import exercise2.FUN
import java.time.LocalDate

// 설명이 이상함 분명 predicate 가 참일때 null 을 반환하라고 하였으나 테스트 상에서는 반대를 요구함
fun <T> T.discardUnless(predicate: (T) -> Boolean): T? = if (predicate(this)) this else null

infix fun <A : Any, B : Any, C : Any> FUN<A, B?>.andUnlessNull(other: FUN<B, C?>): FUN<A, C?> = { a ->
    this(a)?.run { other(this) }
}

data class ToDoItem(
    val description: String,
    val dueDate: LocalDate? = null,
    val status: ToDoStatus = ToDoStatus.Todo
)

enum class ToDoStatus { Todo, InProgress, Done, Blocked }