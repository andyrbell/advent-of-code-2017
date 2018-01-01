object Day25Part1 {
    fun solve(steps: Int): Int {

        val state = move(State('A', 0, mutableMapOf()), steps)
        return state.tape.values.count { it == 1 }
    }

//    In state A:
//    If the current value is 0:
//    - Write the value 1.
//    - Move one slot to the right.
//    - Continue with state B.
//    If the current value is 1:
//    - Write the value 0.
//    - Move one slot to the left.
//    - Continue with state B.
//
//    In state B:
//    If the current value is 0:
//    - Write the value 1.
//    - Move one slot to the left.
//    - Continue with state A.
//    If the current value is 1:
//    - Write the value 1.
//    - Move one slot to the right.
//    - Continue with state A.

    tailrec fun move(state: State, steps: Int): State {

        println("state: ${state.state} position: ${state.position} ${state.tape.toSortedMap()}")
        if (steps == 0) {
            return state
        } else {
            val newValue: Int
            val nextState: Char
            val nextPosition: Int
            when (state.state) {
                'A' -> {
                    nextState = 'B'
                    when(state.tape.getOrDefault(state.position, 0)) {
                        0 -> {
                            newValue = 1
                            nextPosition = state.position + 1
                        }
                        1 -> {
                            newValue = 0
                            nextPosition = state.position - 1
                        }
                        else -> throw IllegalStateException("Invalid value: ${state.tape.getOrDefault(state.position, 0)}")
                    }
                }
                'B' -> {
                    nextState = 'A'
                    when(state.tape.getOrDefault(state.position, 0)) {
                        0 -> {
                            newValue = 1
                            nextPosition = state.position - 1
                        }
                        1 -> {
                            newValue = 1
                            nextPosition = state.position + 1
                        }
                        else -> throw IllegalStateException("Invalid value: ${state.tape.getOrDefault(state.position, 0)}")
                    }
                }
                else -> throw IllegalStateException("Invalid state: ${state.state}")
            }
            state.tape.put(state.position, newValue)
            return move(State(nextState, nextPosition, state.tape), steps - 1)
        }
    }

    data class State(val state: Char, val position: Int, val tape: MutableMap<Int, Int>)
}