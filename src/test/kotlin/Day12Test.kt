import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day12Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day12Test.txt")
        assertThat(Day12Part1().solve(input)).isEqualTo(6)
    }

    @Test
    fun part2() {
        val input = readLines("src/test/resources/Day12Test.txt")
        assertThat(Day12Part2().solve(input)).isEqualTo(2)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day12.txt")
        println("Part 1: " + Day12Part1().solve(input))

    }

    @Test
    fun solvePart2() {
        val input = readLines("src/main/resources/Day12.txt")
        println("Part 2: " + Day12Part2().solve(input))

    }
}