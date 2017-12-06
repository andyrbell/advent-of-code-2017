import org.junit.Test
import kotlin.test.assertEquals

class Day06Test {
    @Test
    fun part1() {
        val input = intArrayOf(0, 2, 7, 0)
        assertEquals(5, Day06Part1().solve(input))
    }

    @Test
    fun part2() {
        val input = intArrayOf(0, 2, 7, 0)
        assertEquals(4, Day06Part2().solve(input))
    }

    @Test
    fun solvePart1() {
        val input = Utils.toIntArray(Utils.readLines("src/main/resources/Day06.txt")[0])
        println("Part 1: " + Day06Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val input = Utils.toIntArray(Utils.readLines("src/main/resources/Day06.txt")[0])
        println("Part 2: " + Day06Part2().solve(input))
    }
}

/**
Out of curiosity, the debugger would also like to know the size of the loop: starting from a state that has already been seen, how many block redistribution cycles must be performed before that same state is seen again?

In the example above, 2 4 1 2 is seen again after four cycles, and so the answer in that example would be 4.

How many cycles are in the infinite loop that arises from the configuration in your puzzle input?
        */