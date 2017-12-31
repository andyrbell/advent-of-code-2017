
import Day22Part1.Grid
import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day22Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day22Test.txt")
        assertThat(Day22Part1.solve(input, 7)).isEqualTo(5)
        assertThat(Day22Part1.solve(input, 70)).isEqualTo(41)
        assertThat(Day22Part1.solve(input, 10000)).isEqualTo(5587)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day22.txt")
        println("Part 1: " + Day22Part1.solve(input, 10000))
    }

    @Test
    fun parse() {
        val input = readLines("src/test/resources/Day22Test.txt")

        val expected = Grid(mutableMapOf(
                Pair(-1, -1) to '.',
                Pair(0, -1) to '.',
                Pair(1, -1) to '#',
                Pair(-1, 0) to '#',
                Pair(0, 0) to '.',
                Pair(1, 0) to '.',
                Pair(-1, 1) to '.',
                Pair(0, 1) to '.',
                Pair(1, 1) to '.'
        ))
        assertThat(Day22Part1.parseGrid(input)).isEqualTo(expected)
    }
}