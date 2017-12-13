
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day05Test {
    @Test
    fun part1() {
        val input = intArrayOf(0, 3, 0, 1, -3)
        assertThat(Day05Part1().solve(input)).isEqualTo(5)
    }

    @Test
    fun part2() {
        val input = intArrayOf(0, 3, 0, 1, -3)
        assertThat(Day05Part2().solve(input)).isEqualTo(10)
    }

    @Test
    fun solvePart1() {
        val input = Utils.toIntArray(Utils.readLines("src/main/resources/Day05.txt"))
        println("Part 1: " + Day05Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val input = Utils.toIntArray(Utils.readLines("src/main/resources/Day05.txt"))
        println("Part 2: " + Day05Part2().solve(input))
    }
}
