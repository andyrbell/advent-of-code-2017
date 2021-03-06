import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day19Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day19Test.txt")
        assertThat(Day19Part1().solve(input)).isEqualTo("ABCDEF")
    }

    @Test
    fun part2() {
        val input = readLines("src/test/resources/Day19Test.txt")
        assertThat(Day19Part2().solve(input)).isEqualTo(38)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day19.txt")
        println("Part 1: " + Day19Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val input = readLines("src/main/resources/Day19.txt")
        println("Part 2: " + Day19Part2().solve(input))
    }
}