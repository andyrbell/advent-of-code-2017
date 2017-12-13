import Utils.readLines
import org.assertj.core.api.Assertions
import org.junit.Test

class Day13Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day13Test.txt")
        Assertions.assertThat(Day13Part1().solve(input)).isEqualTo(24)
    }

    @Test
    fun part2() {
        val input = readLines("src/test/resources/Day13Test.txt")
        Assertions.assertThat(Day13Part2().solve(input)).isEqualTo(10)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day13.txt")
        println("Part 1: " + Day13Part1().solve(input))

    }

    @Test
    fun solvePart2() {
        val input = readLines("src/main/resources/Day13.txt")
        println("Part 2: " + Day13Part2().solve(input))

    }
}