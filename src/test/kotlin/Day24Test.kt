
import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day24Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day24Test.txt")
        assertThat(Day24Part1.solve(input)).isEqualTo(31)
    }

    @Test
    fun part2() {
        val input = readLines("src/test/resources/Day24Test.txt")
        assertThat(Day24Part2.solve(input)).isEqualTo(19)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day24.txt")
        println("Part 1: " + Day24Part1.solve(input))
    }

    @Test
    fun solvePart2() {
        val input = readLines("src/main/resources/Day24.txt")
        println("Part 2: " + Day24Part2.solve(input))
    }
}