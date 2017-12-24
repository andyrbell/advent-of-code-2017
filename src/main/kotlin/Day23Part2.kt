class Day23Part2 {
    fun solve(input:List<String>): Long {
        val registers = mutableMapOf<String, Long>().withDefault { key -> if (key == "a") 1L else 0L }

        var index = 0L

        fun resolve(value: String): Long = value.toLongOrNull()?: registers.getValue(value)

        fun set(register: String, value: String) {
            registers.set(register, resolve(value))
            index++
        }

        fun add(register: String, value: String) {
            registers.set(register, registers.getValue(register) + resolve(value))
            index++
        }

        fun sub(register: String, value: String) {
            registers.set(register, registers.getValue(register) - resolve(value))
            index++
        }

        fun multiply(register: String, value: String) {
            registers.set(register, registers.getValue(register) * resolve(value))
            index++
        }

        fun modulo(register: String, value: String) {
            registers.set(register, registers.getValue(register) % resolve(value))
            index++
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

            println("instruction: $instruction; index: $index; registers: $registers")
            when (instruction[0]) {
                "set" -> set(instruction[1], instruction[2])
                "add" -> add(instruction[1], instruction[2])
                "sub" -> sub(instruction[1], instruction[2])
                "mul" -> multiply(instruction[1], instruction[2])
                "mod" -> modulo(instruction[1], instruction[2])
                "jnz" -> jump(instruction[1], instruction[2])
                else -> throw IllegalArgumentException("Invalid instruction $instruction")
            }
        }

        return resolve("h")
    }

}