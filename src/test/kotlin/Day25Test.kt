
import Utils.readLines
import org.assertj.core.api.Assertions
import org.junit.Test

class Day25Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day25Test.txt")

//        In state A:
//        If the current value is 0:
//        - Write the value 1.
//        - Move one slot to the right.
//        - Continue with state B.
//        If the current value is 1:
//        - Write the value 0.
//        - Move one slot to the left.
//        - Continue with state B.
//
//        In state B:
//        If the current value is 0:
//        - Write the value 1.
//        - Move one slot to the left.
//        - Continue with state A.
//        If the current value is 1:
//        - Write the value 1.
//        - Move one slot to the right.
//        - Continue with state A.


        Assertions.assertThat(Day25Part1.solve(6)).isEqualTo(3)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day25.txt")
//        println("Part 1: " + Day25Part1.solve(input))
    }

}