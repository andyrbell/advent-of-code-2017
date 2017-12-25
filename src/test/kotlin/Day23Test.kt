
import Utils.readLines
import org.junit.Test

class Day23Test {

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day23.txt")
        println("Part 1: " + Day23Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val b = 106500
        val c = 123500
        println("Part 2: " + Day23Part2().solve(b, c))
    }
}