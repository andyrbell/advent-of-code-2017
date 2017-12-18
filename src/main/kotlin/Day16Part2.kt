
import Utils.exchange
import Utils.partner
import Utils.spin
import java.lang.Integer.parseInt

class Day16Part2 {
    fun solve(moves: List<String>, positions: CharArray): CharArray {
        return moves.fold(positions, { acc, move ->
            when (move.take(1)) {
                "s" -> spin(acc, parseInt(move.drop(1)))
                "x" -> {
                    val indexes = move.drop(1).split("/")
                    exchange(acc, parseInt(indexes[0]), parseInt(indexes[1]))
                }
                "p" -> {
                    val chars = move.drop(1).split("/").map { s -> s[0] }
                    partner(acc, chars[0], chars[1])
                }
                else -> throw Exception("invalid move: $move")
            }
        })
    }

    tailrec fun findCycleSize(moves: List<String>, positions: CharArray, original: CharArray, repetitions: Int = 1): Int {
        if (repetitions % 10_000 == 0) println("looking for cycleSize: $repetitions")

        val result = solve(moves, positions)

        return when (result.contentEquals(original)) {
            true -> repetitions
            false -> findCycleSize(moves, result, original, repetitions + 1)
        }
    }

    fun solve(moves: List<String>, positions: CharArray, times: Int): CharArray {

        val cycleSize = findCycleSize(moves, positions, positions.copyOf())

        println("cycleSize: $cycleSize")

        return (1..(times % cycleSize)).fold(positions, { acc, i -> if (i % 10_000 == 0) println(i); solve(moves, acc)})
    }
}