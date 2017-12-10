import Utils.readLines
import Utils.splitCsv
import Utils.toIntArray
import Utils.wrappedSubArray
import Utils.wrappedSet
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
    fun wrappedSubArray() {
        val input = intArrayOf(3, 4, 1, 5)
        assertThat(input.wrappedSubArray(3, 3)).isEqualTo(intArrayOf(5, 3, 4))
    }

    @Test
    fun wrappedSet() {
        val input = intArrayOf(3, 4, 1, 5)
        val subArray = intArrayOf(4, 3, 5)
        assertThat(input.wrappedSet(3, subArray)).isEqualTo(intArrayOf(3, 5, 1, 4))
    }

    @Test
    fun solvePart1() {
        val list = IntArray(256, { i -> i })
        val input = toIntArray(splitCsv(readLines("src/main/resources/Day10.txt")[0]))
        println("Part 1: " + Day10Part1().solve(list, input))

    }

}