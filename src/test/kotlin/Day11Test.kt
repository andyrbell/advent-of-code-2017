import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day11Test {
    @Test
    fun part1() {
        assertThat(Day11Part1().solve("ne,ne,ne")).isEqualTo(3)
        assertThat(Day11Part1().solve("ne,ne,sw,sw")).isEqualTo(0)
        assertThat(Day11Part1().solve("ne,ne,s,s")).isEqualTo(2)
        assertThat(Day11Part1().solve("se,sw,se,sw,sw")).isEqualTo(3)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day11.txt")[0]
        println("Part 1: " + Day11Part1().solve(input))

    }

    @Test
    fun solvePart2() {
        val input = readLines("src/main/resources/Day11.txt")[0]
        println("Part 2: " + Day11Part2().solve(input))
    }
}