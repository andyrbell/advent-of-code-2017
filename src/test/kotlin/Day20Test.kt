import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day20Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day20Test.txt")
        assertThat(Day20Part1().solve(input)).isEqualTo(0)
    }

    @Test
    fun parse() {
        val input = readLines("src/test/resources/Day20Test.txt")
        assertThat(Day20Part1().parse(input[0]))
                .isEqualTo(Day20Part1.Particle(
                        Triple(3, 0, 0),
                        Triple(2, 0, 0),
                        Triple(-1, 0, 0)
                ))
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day20.txt")
        println("Part 1: " + Day20Part1().solve(input))
    }
}