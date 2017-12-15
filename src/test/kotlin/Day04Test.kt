import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * --- Day 4: High-Entropy Passphrases ---
 *
 * A new system policy has been put in place that requires all accounts to use a passphrase instead of simply
 * a password. A passphrase consists of a series of words (lowercase letters) separated by spaces.
 *
 * To ensure security, a valid passphrase must contain no duplicate words.
 *
 * For example:
 *
 * aa bb cc dd ee is valid.
 * aa bb cc dd aa is not valid - the word aa appears more than once.
 * aa bb cc dd aaa is valid - aa and aaa count as different words.
 * The system's full passphrase list is available as your puzzle input.
 * How many passphrases are valid?
 *
 *
 * abcde fghij is a valid passphrase.
abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
iiii oiii ooii oooi oooo is valid.
oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.

 */
class Day04Test {
    @Test
    fun part1() {
        assertThat(Day04Part1().validate("aa bb cc dd ee")).isTrue()
        assertThat(Day04Part1().validate("aa bb cc dd aa")).isFalse()
        assertThat(Day04Part1().validate("aa bb cc dd aaa")).isTrue()
    }

    @Test
    fun part2() {
        assertThat(Day04Part2().validate("abcde fghij")).isTrue()
        assertThat(Day04Part2().validate("abcde xyz ecdab")).isFalse()
        assertThat(Day04Part2().validate("a ab abc abd abf abj")).isTrue()
        assertThat(Day04Part2().validate("iiii oiii ooii oooi oooo")).isTrue()
        assertThat(Day04Part2().validate("oiii ioii iioi iiio")).isFalse()
    }

    @Test
    fun solvePart1() {
        val lines = readLines("src/main/resources/Day04.txt")
        println("Part 1: " + Day04Part1().countValid(lines))
    }

    @Test
    fun solvePart2() {
        val lines = readLines("src/main/resources/Day04.txt")
        println("Part 2: " + Day04Part2().countValid(lines))
    }
}