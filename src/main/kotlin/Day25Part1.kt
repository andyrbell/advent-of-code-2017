object Day25Part1 {
    fun solve(lines: List<String>): Int {
        val beginInStateRegex = """Begin in state ([A-Z]).""".toRegex()
        val beginInState = beginInStateRegex.find(lines[0])!!.groups[1]!!.value[0]
        val stepsRegex = """Perform a diagnostic checksum after (\d+) steps.""".toRegex()
        val steps = stepsRegex.find(lines[1])!!.groups[1]!!.value.toInt()

        val rules = parseRules(lines)

        val initialState = MachineState(beginInState, 0, mutableMapOf())
        val machine = Machine(initialState, rules)
        repeat(steps) {
            machine.execute()
        }
        return machine.checksum()
    }

    private fun parseRules(lines: List<String>): Map<Char, Command> {
        return lines.drop(3)
                .chunked(10)
                .associateBy(
                        { it[0].takeLast(2).first() },
                        { parseCommand(it) }
                )
    }

    private fun parseCommand(lines: List<String>): Command {
        return Command(mapOf(
        0 to parseInstruction(lines.subList(2, 5)),
        1 to parseInstruction(lines.subList(6, 9))
        ))
    }

    private fun parseInstruction(lines: List<String>): Instruction {
        val write = if (lines[0].contains("1")) 1 else 0
        val move = if (lines[1].contains("right")) 1 else -1
        val nextStateRegex = """.* Continue with state ([A-Z]).""".toRegex()
        val nextState = nextStateRegex.find(lines[2])!!.groups[1]!!.value[0]
        return Instruction(nextState, write, move)
    }

    data class MachineState(val state: Char, val position: Int, val tape: MutableMap<Int, Int>)

    data class Command(private val instructions: Map<Int, Instruction>) {
        fun execute(state: MachineState): MachineState {
            val currentValue = state.tape.getOrDefault(state.position, 0)
            val instruction = instructions.getValue(currentValue)
            state.tape.put(state.position, instruction.write)
            return MachineState(instruction.nextState, state.position + instruction.move, state.tape)
        }
    }

    data class Instruction(val nextState: Char, val write: Int, val move: Int)

    data class Machine(private var machineState: MachineState, val rules: Map<Char, Command>) {
        private fun nextCommand(): Command = rules.getValue(machineState.state)

        fun execute() {
            machineState = nextCommand().execute(machineState)
        }

        fun checksum() = machineState.tape.values.count { it == 1 }
    }
}