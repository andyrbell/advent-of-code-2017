import Utils.Direction
import Utils.Direction.*
import Utils.neighbours

class Day03Part2 {
    fun solve(input: Int): Int {

        val initial = Pair(0, 0)
        val direction = SOUTH
        val grid: HashMap<Pair<Int, Int>, Int> = hashMapOf(initial to 1)

        return find(State(initial, direction), grid, input)

    }

    private fun find(state: State, grid: HashMap<Pair<Int, Int>, Int>, target: Int): Int {
        val positionValue = grid.getOrDefault(state.position, 0)
        return when (positionValue > target) {
            true -> positionValue
            false -> find(next(state, grid), grid, target)
        }
    }

    private fun next(state: State, grid: HashMap<Pair<Int, Int>, Int>): State {
        val nextLeft = nextLeft(state)
        val nextAhead = nextAhead(state)

        val nextMove = when (grid.containsKey(nextLeft.position)) {
            true -> nextAhead
            false -> nextLeft
        }
        val nextValue = nextMove.position.neighbours().map { grid.getOrDefault(it, 0) }.sum()
        grid.put(nextMove.position, nextValue)
        return nextMove
    }

    private fun nextLeft(state: State): State =
        when (state.direction) {
            NORTH -> State(Pair(state.position.first - 1, state.position.second), WEST)
            SOUTH -> State(Pair(state.position.first + 1, state.position.second), EAST)
            WEST -> State(Pair(state.position.first, state.position.second - 1), SOUTH)
            EAST -> State(Pair(state.position.first, state.position.second + 1), NORTH)
        }

    private fun nextAhead(state: State): State =
        when (state.direction) {
            NORTH -> State(Pair(state.position.first, state.position.second + 1), NORTH)
            SOUTH -> State(Pair(state.position.first, state.position.second - 1), SOUTH)
            WEST -> State(Pair(state.position.first - 1, state.position.second), WEST)
            EAST -> State(Pair(state.position.first + 1, state.position.second), EAST)
        }

    data class State(val position: Pair<Int, Int>, val direction: Direction)
}