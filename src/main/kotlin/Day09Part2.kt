class Day09Part2 {
    fun solve(input: String): Int {
        return input.fold(State(), { acc, c -> when {
            acc.cancelled -> State(acc.depth, acc.garbage, false, acc.totalGarbage)
            c == '!' -> State(acc.depth, acc.garbage, true, acc.totalGarbage)
            acc.garbage && c == '>' -> State(acc.depth, false, false, acc.totalGarbage)
            acc.garbage -> State(acc.depth, true, false, acc.totalGarbage + 1)
            c == '<' -> State(acc.depth, true, false, acc.totalGarbage)
            c == '}' -> State(acc.depth - 1, false, false, acc.totalGarbage)
            c == '{' -> State(acc.depth + 1, false, false, acc.totalGarbage)
            else -> acc
        }}).totalGarbage
    }

    data class State(val depth: Int = 0, val garbage: Boolean = false, val cancelled: Boolean = false, val totalGarbage: Int = 0)

}