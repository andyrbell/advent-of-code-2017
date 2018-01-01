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
        if (steps == 0) {
            return state
        } else {
            val commands = mapOf(
                    'A' to Command(
                            mapOf(0 to Instruction('B', 1, 1),
                            1 to Instruction('B', 0, -1)
                    )),
                    'B' to Command(mapOf(
                            0 to Instruction('A', 1, -1),
                            1 to Instruction('A', 1, 1)
                    )))

            return move(commands[state.state]!!.execute(state), steps - 1)
        }
    }

    data class State(val state: Char, val position: Int, val tape: MutableMap<Int, Int>)

    data class Command(private val instructions: Map<Int, Instruction>) {
        fun execute(state: State): State {
            val currentValue = state.tape.getOrDefault(state.position, 0)
            val instruction = instructions.getValue(currentValue)
            state.tape.put(state.position, instruction.write)
            return State(instruction.nextState, state.position + instruction.move, state.tape)
        }
    }

    data class Instruction(val nextState: Char, val write: Int, val move: Int)
}