
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day17Test {
    @Test
    fun part1() {
        assertThat(Day17Part1().solve(3)).isEqualTo(638)
    }

    @Test
    fun solvePart1() {
        println("Part 1: " + Day17Part1().solve(359))
    }
}
