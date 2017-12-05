import Utils.readLines
import org.junit.Test
import kotlin.test.assertEquals

class Day02Test {
    @Test
    fun part1() {
        assertEquals(8, Day02Part1().checksum("5 1 9 5"))
        assertEquals(4, Day02Part1().checksum("7 5 3"))
        assertEquals(6, Day02Part1().checksum("2 4 6 8"))
    }

    @Test
    fun part2() {
        assertEquals(4, Day02Part2().checksum("5 9 2 8"))
        assertEquals(3, Day02Part2().checksum("9 4 7 3"))
        assertEquals(2, Day02Part2().checksum("3 8 6 5"))
    }

    @Test
    fun solvePart1() {
        val lines = readLines("src/main/resources/Day02.txt")
        println("Part 1: " + Day02Part1().checksum(lines))
    }

    @Test
    fun solvePart2() {
        val lines = readLines("src/main/resources/Day02.txt")
        println("Part 2: " + Day02Part2().checksum(lines))
    }
}