import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotallerTest {
    @Test
    fun shouldBeAbleToAdd3() {
        val totaller = Totaller()
        assertEquals(3, totaller.add(3))
        assertEquals(3, totaller.total)
    }

    @Test
    fun `should be able to add 3 and 4`() { //Name wrapped in back-ticks
        val totaller = Totaller()
        assertEquals(3, totaller.add(3))
        assertEquals(7, totaller.add(4))
        assertEquals(7, totaller.total)
    }
}