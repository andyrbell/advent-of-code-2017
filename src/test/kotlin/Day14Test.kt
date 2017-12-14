
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day14Test {
    @Test
    fun part1() {
        assertThat(Day14Part1().solve("flqrgnkx")).isEqualTo(8108)
    }

    @Test
    fun toBits() {
        assertThat(Utils.toBitString("d4f76bdcbf838f8416ccfa8bc6d1f9e6")).startsWith("11010100")
    }

    @Test
    fun solvePart1() {
        println("Part 1: " + Day14Part1().solve("ljoxqyyw"))

    }
}