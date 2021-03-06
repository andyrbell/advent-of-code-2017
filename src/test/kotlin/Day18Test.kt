
import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day18Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day18Test.txt")
        assertThat(Day18Part1().solve(input)).isEqualTo(4)
    }

    @Test
    fun part2() {
        val input = readLines("src/test/resources/Day18Test2.txt")
        assertThat(Day18Part2().solve(input)).isEqualTo(3)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day18.txt")
        println("Part 1: " + Day18Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val input = readLines("src/main/resources/Day18.txt")
        println("Part 2: " + Day18Part2().solve(input))
    }
}