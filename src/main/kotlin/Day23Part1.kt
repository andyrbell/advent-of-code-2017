class Day23Part1 {
    fun solve(input: List<String>): Int {
        val registers = mutableMapOf<String, Long>().withDefault { 0L }

        var multiplications = 0

        var index = 0L

        fun resolve(value: String): Long = value.toLongOrNull()?: registers.getValue(value)

        fun set(register: String, value: String) {
            registers.set(register, resolve(value))
            index++
        }

        fun sub(register: String, value: String) {
            registers.set(register, registers.getValue(register) - resolve(value))
            index++
        }

        fun multiply(register: String, value: String) {
            registers.set(register, registers.getValue(register) * resolve(value))
            index++
            multiplications++
        }

        fun jump(register: String, value: String) {
            if (resolve(register) != 0L) {
                index += resolve(value)
            } else {
                index++
            }
        }

        while (index.toInt() in 0..(input.size - 1)) {
            val instruction = Utils.toWords(input.get(index.toInt()))

            println("instruction: $instruction; index: $index; registers: $registers; multiplications: $multiplications")
            when (instruction[0]) {
                "set" -> set(instruction[1], instruction[2])
                "sub" -> sub(instruction[1], instruction[2])
                "mul" -> multiply(instruction[1], instruction[2])
                "jnz" -> jump(instruction[1], instruction[2])
                else -> throw IllegalArgumentException("Invalid instruction $instruction")
            }
        }

        return multiplications
    }

}