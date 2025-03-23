package exercise3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BuildCharAtPosTest {
    @Test
    fun testBuildCharAtPos() {
        val result = buildCharAtPos("Kotlin")

        assertEquals(result(0), 'K')
    }
}