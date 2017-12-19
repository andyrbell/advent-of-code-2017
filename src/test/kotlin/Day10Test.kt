
import Utils.readLines
import Utils.splitCsv
import Utils.toIntArray
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day10Test {
    @Test
    fun part1() {
        val list = IntArray(5, { i -> i })
        val input = intArrayOf(3, 4, 1, 5)
        assertThat(Day10Part1().solve(list, input)).isEqualTo(12)
    }

    @Test
    fun part2() {
        assertThat(Day10Part2().solve("")).isEqualTo("a2582a3a0e66e6e86e3812dcb672a272")
        assertThat(Day10Part2().solve("AoC 2017")).isEqualTo("33efeb34ea91902bb2f59c9920caa6cd")
        assertThat(Day10Part2().solve("1,2,3")).isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d")
        assertThat(Day10Part2().solve("1,2,4")).isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e")
    }

    @Test
    fun solvePart1() {
        val list = IntArray(256, { i -> i })
        val input = toIntArray(splitCsv(readLines("src/main/resources/Day10.txt")[0]))
        println("Part 1: " + Day10Part1().solve(list, input))
    }

    @Test
    fun solvePart2() {
        val input = readLines("src/main/resources/Day10.txt")[0]
        println("Part 2: " + Day10Part2().solve(input))
    }
}