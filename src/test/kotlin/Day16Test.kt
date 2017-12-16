import Utils.readLines
import Utils.splitCsv
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day16Test {
    @Test
    fun part1() {
        val input = splitCsv(readLines("src/test/resources/Day16Test.txt").get(0))
        assertThat(Day16Part1().solve(input, "abcde")).isEqualTo("baedc")
    }

    @Test
    fun solvePart1() {
        val input = splitCsv(readLines("src/main/resources/Day16.txt").get(0))
        println("Part 1: " + Day16Part1().solve(input, "abcdefghijklmnop"))
    }
}