
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day15Test {
    @Test
    fun part1() {
        assertThat(Day15Part1().solve(65, 8921)).isEqualTo(588)
    }

    @Test
    fun part2() {
        assertThat(Day15Part2().solve(65, 8921)).isEqualTo(309)
    }

    @Test
    fun solvePart1() {
        println("Part 1: " + Day15Part1().solve(512, 191))

    }

    @Test
    fun solvePart2() {
        println("Part 2: " + Day15Part2().solve(512, 191))

    }
}