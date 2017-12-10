import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day09Test {
    @Test
    fun part1() {
        assertThat(Day09Part1().solve("{}")).isEqualTo(1)
        assertThat(Day09Part1().solve("{{{}}}")).isEqualTo(6)
        assertThat(Day09Part1().solve("{{},{}}")).isEqualTo(5)
        assertThat(Day09Part1().solve("{{{},{},{{}}}}")).isEqualTo(16)
        assertThat(Day09Part1().solve("{<a>,<a>,<a>,<a>}")).isEqualTo(1)
        assertThat(Day09Part1().solve("{{<ab>},{<ab>},{<ab>},{<ab>}}")).isEqualTo(9)
        assertThat(Day09Part1().solve("{{<!!>},{<!!>},{<!!>},{<!!>}}")).isEqualTo(9)
        assertThat(Day09Part1().solve("{{<a!>},{<a!>},{<a!>},{<ab>}}")).isEqualTo(3)
    }

    @Test
    fun part2() {
        assertThat(Day09Part2().solve("<>")).isEqualTo(0)
        assertThat(Day09Part2().solve("<random characters>")).isEqualTo(17)
        assertThat(Day09Part2().solve("<<<<>")).isEqualTo(3)
        assertThat(Day09Part2().solve("<{!>}>")).isEqualTo(2)
        assertThat(Day09Part2().solve("<!!>")).isEqualTo(0)
        assertThat(Day09Part2().solve("<!!!>>")).isEqualTo(0)
        assertThat(Day09Part2().solve("<{o\"i!a,<{i<a>")).isEqualTo(10)
    }

    @Test
    fun solvePart1() {
        val input = Utils.readLines("src/main/resources/Day09.txt")[0]
        println("Part 1: " + Day09Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val input = Utils.readLines("src/main/resources/Day09.txt")[0]
        println("Part 2: " + Day09Part2().solve(input))
    }

}