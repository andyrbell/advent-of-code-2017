import Utils.Direction
import Utils.Direction.*

object Day22Part1 {
    fun solve(input: List<String>, bursts: Int): Int {

        val grid = parseGrid(input)

        val initialPosition = Pair(0, 0)
        val initialDirection = NORTH

        val initialState = State(initialPosition, initialDirection, grid)

        return burst(initialState, bursts)
    }

    tailrec fun burst(state: State, bursts: Int): Int {
        if (bursts == 0) {
            return state.grid.infections
        } else {
            val nextState: State
            when (state.grid.infected(state.position)) {
                true -> {
                    nextState = turnRight(state)
                    nextState.grid.clean(nextState.position)
                }
                else -> {
                    nextState = turnLeft(state)
                    nextState.grid.infect(nextState.position)
                }
            }
            return burst(move(nextState), bursts - 1)
        }
    }

    fun parseGrid(input: List<String>): Grid {
        val xOffset = Math.floorDiv(input.first().length, 2)
        val yOffset = Math.floorDiv(input.size, 2)

        return Grid(input.mapIndexed { yIndex, line ->
            line.mapIndexed { xIndex, c ->
                Pair(xIndex - xOffset, yIndex - yOffset) to c
            }
        }.flatMap { it }.toMap().toMutableMap())
    }

    private fun turnLeft(state: State): State =
            when (state.direction) {
                NORTH -> State(state.position, WEST, state.grid)
                SOUTH -> State(state.position, EAST, state.grid)
                WEST -> State(state.position, SOUTH, state.grid)
                EAST -> State(state.position, NORTH, state.grid)
            }

    private fun turnRight(state: State): State =
            when (state.direction) {
                NORTH -> State(state.position, EAST, state.grid)
                SOUTH -> State(state.position, WEST, state.grid)
                WEST -> State(state.position, NORTH, state.grid)
                EAST -> State(state.position, SOUTH, state.grid)
            }

    private fun move(state: State): State =
            when (state.direction) {
                NORTH -> State(Pair(state.position.first, state.position.second - 1), NORTH, state.grid)
                SOUTH -> State(Pair(state.position.first, state.position.second + 1), SOUTH, state.grid)
                WEST -> State(Pair(state.position.first - 1, state.position.second), WEST, state.grid)
                EAST -> State(Pair(state.position.first + 1, state.position.second), EAST, state.grid)
            }

    data class State(val position: Pair<Int, Int>, val direction: Direction, val grid: Grid)

    data class Grid(val nodes: MutableMap<Pair<Int, Int>, Char>, var infections: Int = 0) {

        fun infected(position: Pair<Int, Int>): Boolean = nodes.getOrDefault(position, '.') == '#'

        fun clean(position: Pair<Int, Int>) {
            nodes.put(position, '.')
        }

        fun infect(position: Pair<Int, Int>) {
            nodes.put(position, '#')
            infections++
        }
    }
}

