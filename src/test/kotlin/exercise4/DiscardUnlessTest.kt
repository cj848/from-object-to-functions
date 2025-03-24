package exercise4

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class DiscardUnlessTest {

    @Test
    fun exercise4_1() {
        val itemInProgress = ToDoItem("doing something", status = ToDoStatus.InProgress)
        val itemBlocked = ToDoItem("must do something", status = ToDoStatus.Blocked)

        expectThat(itemInProgress.discardUnless { it.status == ToDoStatus.InProgress }).isEqualTo(itemInProgress)
        expectThat(itemBlocked.discardUnless { it.status == ToDoStatus.InProgress }).isEqualTo(null)
    }

    @Test
    fun exercise4_2() {
        fun testA(a: String): Int? {
            return a.toIntOrNull()
        }
        fun testB(b: Int): Double? {
            return b.toDouble()
        }
        fun testC(c: Double): Float? {
            return c.toFloat()
        }

        val func = ::testA andUnlessNull ::testB andUnlessNull ::testC

        expectThat(func("a")).isEqualTo(null)
        expectThat(func("1")).isEqualTo(1f)
    }
}