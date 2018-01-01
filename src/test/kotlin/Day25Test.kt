
import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day25Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day25Test.txt")
        assertThat(Day25Part1.solve(input)).isEqualTo(3)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day25.txt")
        println("Part 1: " + Day25Part1.solve(input))
    }
}