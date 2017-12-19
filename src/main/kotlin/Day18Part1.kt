class Day18Part1 {
    fun solve(input: List<String>): Long {
        val registers = mutableMapOf<String, Long>().withDefault { 0L }

        val soundsPlayed = mutableListOf<Long>()

        var index = 0L
        var recovered = false

        fun resolve(value: String): Long = value.toLongOrNull()?: registers.getValue(value)

        fun sound(frequency: String) {
            soundsPlayed.add(resolve(frequency))
            index++
        }

        fun set(register: String, value: String) {
            registers.set(register, resolve(value))
            index++
        }

        fun add(register: String, value: String) {
            registers.set(register, registers.getValue(register) + resolve(value))
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

        fun recover(register: String) {
            if (registers.getValue(register) != 0L) {
                println("rcv: ${soundsPlayed.last()}")
                recovered = true
            } else {
                index++
            }
        }

        fun jump(register: String, value: String) {
            if (registers.getValue(register) > 0) {
                index += resolve(value)
            } else {
                index++
            }
        }

        while (!recovered) {
            val instruction = Utils.toWords(input.get(index.toInt()))

            println("instruction: $instruction; registers: $registers")
            when (instruction[0]) {
                "snd" -> sound(instruction[1])
                "set" -> set(instruction[1], instruction[2])
                "add" -> add(instruction[1], instruction[2])
                "mul" -> multiply(instruction[1], instruction[2])
                "mod" -> modulo(instruction[1], instruction[2])
                "rcv" -> recover(instruction[1])
                "jgz" -> jump(instruction[1], instruction[2])
                else -> throw IllegalArgumentException("Invalid instruction $instruction")
            }
        }

        return soundsPlayed.last()
    }

}