import org.junit.Test
import kotlin.test.assertEquals

class Day09Test {
    @Test
    fun part1() {
        assertEquals(1, Day09Part1().solve("{}"))
        assertEquals(6, Day09Part1().solve("{{{}}}"))
        assertEquals(5, Day09Part1().solve("{{},{}}"))
        assertEquals(16, Day09Part1().solve("{{{},{},{{}}}}"))
        assertEquals(1, Day09Part1().solve("{<a>,<a>,<a>,<a>}"))
        assertEquals(9, Day09Part1().solve("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
        assertEquals(9, Day09Part1().solve("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
        assertEquals(3, Day09Part1().solve("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
    }

    @Test
    fun part2() {
        assertEquals(0, Day09Part2().solve("<>"))
        assertEquals(17, Day09Part2().solve("<random characters>"))
        assertEquals(3, Day09Part2().solve("<<<<>"))
        assertEquals(2, Day09Part2().solve("<{!>}>"))
        assertEquals(0, Day09Part2().solve("<!!>"))
        assertEquals(0, Day09Part2().solve("<!!!>>"))
        assertEquals(10, Day09Part2().solve("<{o\"i!a,<{i<a>"))
    }

    @Test
    fun solvePart1() {
        val input = Utils.readLines("src/main/resources/Day09.txt")[0]
        println("Part 1: " + Day09Part1().solve(input))

    }

    @Test
    fun solvePart2() {
        val input = Utils.readLines("src/main/resources/Day09.txt")[0]
        println("Part 2: " + Day09Part2().solve(input))

    }

}