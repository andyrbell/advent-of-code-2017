class Day09Part1 {
    fun solve(input: String): Int {
        return input.fold(State(), { acc, c -> when {
            acc.cancelled -> State(acc.depth, acc.garbage, false, acc.total)
            acc.garbage && c == '>' -> State(acc.depth, false, false, acc.total)
            c == '!' -> State(acc.depth, acc.garbage, true, acc.total)
            acc.garbage -> acc
            c == '<' -> State(acc.depth, true, false, acc.total)
            c == '}' -> State(acc.depth - 1, false, false, acc.total + acc.depth)
            c == '{' -> State(acc.depth + 1, false, false, acc.total)
            else -> acc
        }}).total
    }

    data class State(val depth: Int = 0, val garbage: Boolean = false, val cancelled: Boolean = false, val total: Int = 0)

}