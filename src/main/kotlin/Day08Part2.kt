class Day08Part2 {
    fun solve(input: List<String>): Int {
        val registers = mutableMapOf<String, Int>().withDefault { _ -> 0 }

        input.forEach {
            val instruction = parse(it)
            if (instruction.second.apply(registers)) {
                instruction.first.apply(registers)
            }
        }
        return registers.getValue("max")
    }

    private fun parse(line: String): Pair<Operation, Predicate> {
        val regex = """(\w+) (inc|dec) (-?\d+) if (\w+) ([<>=!]+) (-?\d+)""".toRegex()

        val (register, op, value, register2, op2, value2) = regex.find(line)!!.destructured

        return Pair(Operation(register, op, Integer.valueOf(value)), Predicate(register2, op2, Integer.valueOf(value2)))

    }

    data class Operation(private val register: String, private val operator: String, private val value: Int) {
        fun apply(registers: MutableMap<String, Int>) {
            when (operator) {
                "inc" -> {
                    val newValue = registers.getValue(register) + value
                    registers.put(register, newValue)
                    registers.merge("max", newValue, { oldVal, newVal -> Math.max(oldVal, newVal) })
                }
                "dec" -> {
                    val newValue = registers.getValue(register) - value
                    registers.put(register, newValue)
                    registers.merge("max", newValue, { oldVal, newVal -> Math.max(oldVal, newVal) })
                }
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