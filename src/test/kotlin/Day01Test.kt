import org.junit.Test
import kotlin.test.assertEquals

/**
 * Part 1:
 * 1122 produces a part1 of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
 * 1111 produces 4 because each digit (all 1) matches the next.
 * 1234 produces 0 because no digit matches the next.
 * 91212129 produces 9 because the only digit that matches the next one is the last digit, 9.
 *
 * Part 2:
 * 1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
 * 1221 produces 0, because every comparison is between a 1 and a 2.
 * 123425 produces 4, because both 2s match each other, but no other digit has a match.
 * 123123 produces 12.
 * 12131415 produces 4.
 */
class Day01Test {
    @Test
    fun test1() {
        val input = "1122"
        assertEquals(3, Day01().part1(input))
    }

    @Test
    fun test2() {
        val input = "1111"
        assertEquals(4, Day01().part1(input))
    }

    @Test
    fun test3() {
        val input = "1234"
        assertEquals(0, Day01().part1(input))
    }

    @Test
    fun test4() {
        val input = "91212129"
        assertEquals(9, Day01().part1(input))
    }

    @Test
    fun test5() {
        val input = "1212"
        assertEquals(6, Day01().part2(input))
    }

    @Test
    fun test6() {
        val input = "1221"
        assertEquals(0, Day01().part2(input))
    }

    @Test
    fun test7() {
        val input = "123425"
        assertEquals(4, Day01().part2(input))
    }

    @Test
    fun test8() {
        val input = "123123"
        assertEquals(12, Day01().part2(input))
    }

    @Test
    fun test9() {
        val input = "12131415"
        assertEquals(4, Day01().part2(input))
    }

}