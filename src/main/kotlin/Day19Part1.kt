import Utils.Direction
import Utils.Direction.*

class Day19Part1 {
    fun solve(input: List<String>): String {
        val startX = input[0].indexOf('|')
        val initialPosition = Pair(startX, 0)
        val initialState = State(initialPosition, SOUTH)
        return recurse(initialState, input)
    }

    tailrec fun recurse(state: State, input: List<String>): String {
        val direction = state.direction
        val position = state.position

        val nextInLine = when (direction) {
            NORTH -> Pair(position.first, position.second - 1)
            EAST -> Pair(position.first + 1, position.second)
            SOUTH -> Pair(position.first, position.second + 1)
            WEST -> Pair(position.first - 1, position.second)
        }

        val nextChar = input[nextInLine.second][nextInLine.first]

        return when {
            nextChar.isLetter() -> recurse(State(nextInLine, direction, state.letters + nextChar), input)
            nextChar.isWhitespace() -> state.letters
            nextChar == '|' || nextChar == '-' -> recurse(State(nextInLine, direction, state.letters), input)
            nextChar == '+' -> recurse(turn(State(nextInLine, direction, state.letters), input), input)
            else -> throw IllegalArgumentException("invalid char: $nextChar")
        }
    }

    fun turn(state: State, input: List<String>): State {
        val direction = state.direction
        val position = state.position

        return when (direction) {
            NORTH, SOUTH -> listOf(
                                State(Pair(position.first - 1, position.second), WEST, state.letters),
                                State(Pair(position.first + 1, position.second), EAST, state.letters)
                            )
            EAST, WEST -> listOf(
                                State(Pair(position.first, position.second - 1), NORTH, state.letters),
                                State(Pair(position.first, position.second + 1), SOUTH, state.letters)
                            )
        }
                .filter { it.position.second in 0..(input.size - 1) }
                .filter { it.position.first in 0..(input[it.position.second].length - 1) }
                .first { !input[it.position.second][it.position.first].isWhitespace() }
                .let { State(position, it.direction, it.letters) }
    }

    data class State(val position: Pair<Int, Int>, val direction: Direction, val letters: String = "")

}