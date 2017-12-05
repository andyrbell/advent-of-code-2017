import org.junit.Test
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun part1() {
        assertEquals(0, Day03Part1().solve(1))
        assertEquals(3, Day03Part1().solve(12))
        assertEquals(2, Day03Part1().solve(23))
        assertEquals(31, Day03Part1().solve(1024))
    }

    @Test
    fun solvePart1() {
        println("Part 1: " + Day03Part1().solve(361527))
    }

}
