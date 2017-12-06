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

    @Test
    fun part2() {
        assertEquals(2, Day03Part2().solve(1))
        assertEquals(10, Day03Part2().solve(9))
        assertEquals(122, Day03Part2().solve(121))
        assertEquals(806, Day03Part2().solve(805))
    }

    @Test
    fun solvePart2() {
        println("Part 2: " + Day03Part2().solve(361527))
    }

}
