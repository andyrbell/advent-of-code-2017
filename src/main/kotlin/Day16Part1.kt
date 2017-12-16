
import Utils.exchange
import Utils.partner
import Utils.spin
import java.lang.Integer.parseInt

class Day16Part1 {
    fun solve(moves: List<String>, positions: String): String {
        return moves.fold(positions, { acc, move ->
            when (move.take(1)) {
                "s" -> acc.spin(parseInt(move.drop(1)))
                "x" -> {
                    val indexes = move.drop(1).split("/")
                    acc.exchange(parseInt(indexes[0]), parseInt(indexes[1]))
                }
                "p" -> {
                    val chars = move.drop(1).split("/").map { s -> s[0] }
                    acc.partner(chars[0], chars[1])
                }
                else -> throw Exception("invalid move: $move")
            }
        })
    }
}