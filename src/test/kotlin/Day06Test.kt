
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day06Test {
    @Test
    fun part1() {
        val input = intArrayOf(0, 2, 7, 0)
        assertThat(Day06Part1().solve(input)).isEqualTo(5)
    }

    @Test
    fun part2() {
        val input = intArrayOf(0, 2, 7, 0)
        assertThat(Day06Part2().solve(input)).isEqualTo(4)
    }

    @Test
    fun solvePart1() {
        val input = Utils.toIntArray(Utils.readLines("src/main/resources/Day06.txt")[0])
        println("Part 1: " + Day06Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val input = Utils.toIntArray(Utils.readLines("src/main/resources/Day06.txt")[0])
        println("Part 2: " + Day06Part2().solve(input))
    }
}
