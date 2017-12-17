
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

    fun solve(moves: List<String>, positions: CharArray, times: Int): CharArray {
        return (1..times).fold(positions, { acc, i -> if (i % 10_000 == 0) println(i); solve(moves, acc)})
    }
}