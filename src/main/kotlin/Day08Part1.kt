class Day08Part1 {
    fun solve(input: List<String>): Int {
        val registers = mutableMapOf<String, Int>().withDefault { _ -> 0 }

        input.forEach {
            val instruction = parse(it)
            if (instruction.second.apply(registers)) {
                instruction.first.apply(registers)
            }
        }
        return registers.maxBy { it.value }!!.value
    }

    private fun parse(line: String): Pair<Operation, Predicate> {
        val regex = """(\w+) (inc|dec) (-?\d+) if (\w+) ([<>=!]+) (-?\d+)""".toRegex()

        val (register, op, value, register2, op2, value2) = regex.find(line)!!.destructured

        return Pair(Operation(register, op, Integer.valueOf(value)), Predicate(register2, op2, Integer.valueOf(value2)))

    }

    data class Operation(private val register: String, private val operator: String, private val value: Int) {
        fun apply(registers: MutableMap<String, Int>) {
            when (operator) {
                "inc" -> registers.put(register, registers.getValue(register) + value)
                "dec" -> registers.put(register, registers.getValue(register) - value)
            }
        }
    }

    data class Predicate(private val register: String, private val operator: String, private val value: Int) {
        fun apply(registers: MutableMap<String, Int>): Boolean {
            return when (operator) {
                ">" -> registers.getValue(register) > value
                ">=" -> registers.getValue(register) >= value
                "<" -> registers.getValue(register) < value
                "<=" -> registers.getValue(register) <= value
                "==" -> registers.getValue(register) == value
                "!=" -> registers.getValue(register) != value
                else -> throw IllegalStateException("Invalid operator $operator")
            }
        }
    }
}