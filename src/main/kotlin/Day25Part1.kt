import java.time.Instant

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

//        println("state: ${state.state} position: ${state.position} ${state.tape.toSortedMap()}")
        if (steps % 10_000 == 0) println("${Instant.now()} - $steps")
        if (steps == 0) {
            return state
        } else {
            val newValue: Int
            val nextState: Char
            val nextPosition: Int
            when (state.state) {
                'A' -> {
                    when(state.tape.getOrDefault(state.position, 0)) {
                        0 -> {
                            newValue = 1
                            nextPosition = state.position + 1
                            nextState = 'B'
                        }
                        1 -> {
                            newValue = 1
                            nextPosition = state.position - 1
                            nextState = 'E'
                        }
                        else -> throw IllegalStateException("Invalid value: ${state.tape.getOrDefault(state.position, 0)}")
                    }
                }
                'B' -> {
                    when(state.tape.getOrDefault(state.position, 0)) {
                        0 -> {
                            newValue = 1
                            nextPosition = state.position + 1
                            nextState = 'C'
                        }
                        1 -> {
                            newValue = 1
                            nextPosition = state.position + 1
                            nextState = 'F'
                        }
                        else -> throw IllegalStateException("Invalid value: ${state.tape.getOrDefault(state.position, 0)}")
                    }
                }
                'C' -> {
                    when(state.tape.getOrDefault(state.position, 0)) {
                        0 -> {
                            newValue = 1
                            nextPosition = state.position - 1
                            nextState = 'D'
                        }
                        1 -> {
                            newValue = 0
                            nextPosition = state.position + 1
                            nextState = 'B'
                        }
                        else -> throw IllegalStateException("Invalid value: ${state.tape.getOrDefault(state.position, 0)}")
                    }
                }
                'D' -> {
                    when(state.tape.getOrDefault(state.position, 0)) {
                        0 -> {
                            newValue = 1
                            nextPosition = state.position + 1
                            nextState = 'E'
                        }
                        1 -> {
                            newValue = 0
                            nextPosition = state.position - 1
                            nextState = 'C'
                        }
                        else -> throw IllegalStateException("Invalid value: ${state.tape.getOrDefault(state.position, 0)}")
                    }
                }
                'E' -> {
                    when(state.tape.getOrDefault(state.position, 0)) {
                        0 -> {
                            newValue = 1
                            nextPosition = state.position - 1
                            nextState = 'A'
                        }
                        1 -> {
                            newValue = 0
                            nextPosition = state.position + 1
                            nextState = 'D'
                        }
                        else -> throw IllegalStateException("Invalid value: ${state.tape.getOrDefault(state.position, 0)}")
                    }
                }
                'F' -> {
                    when(state.tape.getOrDefault(state.position, 0)) {
                        0 -> {
                            newValue = 1
                            nextPosition = state.position + 1
                            nextState = 'A'
                        }
                        1 -> {
                            newValue = 1
                            nextPosition = state.position + 1
                            nextState = 'C'
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

    data class Command(private val instructions: Map<Int, Instruction>) {
        fun execute(state: State): State {
            val currentValue = state.tape.getOrDefault(state.position, 0)
            val instruction = instructions.getValue(currentValue)
            return State(instruction.nextState, state.position + instruction.move, state.tape)
        }
    }

    data class Instruction(val nextState: Char, val write: Int, val move: Int)
}