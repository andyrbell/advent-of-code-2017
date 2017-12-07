import org.junit.Test
import kotlin.test.assertEquals

class Day07Test {
    @Test
    fun part1() {
        val input = Utils.readLines("src/test/resources/Day07Test.txt")
        assertEquals("tknk", Day07Part1().solve(input))
    }

    @Test
    fun part2() {
        val input = Utils.readLines("src/test/resources/Day07Test.txt")
        assertEquals(60, Day07Part2().solve(input))
    }

    @Test
    fun solvePart1() {
        val input = Utils.readLines("src/main/resources/Day07.txt")
        println("Part 1: " + Day07Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val input = Utils.readLines("src/main/resources/Day07.txt")
        println("Part 2: " + Day07Part2().solve(input))
    }
}