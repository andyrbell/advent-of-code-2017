
import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day23Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day23Test.txt")
        assertThat(Day23Part1().solve(input)).isEqualTo(1)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day23.txt")
        println("Part 1: " + Day23Part1().solve(input))
    }
}