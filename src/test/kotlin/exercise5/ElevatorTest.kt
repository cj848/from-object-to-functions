package exercise5

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ElevatorTest {
    @Test
    fun calc() {
        val values = listOf(Up, Up, Down, Up, Down, Down, Up, Up, Up, Down)
        val tot = values.fold(Elevator(0)) { e, d ->
            when (d) {
                is Up -> Elevator(e.floor + 1)
                is Down -> Elevator(e.floor - 1)
            }
        }
        expectThat(tot).isEqualTo(Elevator(2))
    }
}