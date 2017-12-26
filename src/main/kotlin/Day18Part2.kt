
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeoutOrNull

class Day18Part2 {
    fun solve(input: List<String>): Int {
        val channels = listOf(Channel<Long>(Channel.UNLIMITED), Channel(Channel.UNLIMITED))
        val sendsPerChannel = mutableListOf(0, 0)

        runBlocking {
            val coroutines = List(2) { i ->
                async(coroutineContext) {
                    Program(i, channels, sendsPerChannel).run(input)
                }
            }
            coroutines.forEach { it.join() }
        }

        return sendsPerChannel[1]

    }

    data class Program(private val id: Int, private val channels: List<Channel<Long>>, private val sendsPerChannel: MutableList<Int>) {
        private var index = 0
        private val otherProgramId = (id + 1) % 2
        private val registers = mutableMapOf("p" to id.toLong()).withDefault { 0L }

        private fun resolve(value: String): Long = value.toLongOrNull()?: registers.getValue(value)

        private fun set(register: String, value: String) {
            registers.set(register, resolve(value))
            index++
        }

        private fun add(register: String, value: String) {
            registers.set(register, registers.getValue(register) + resolve(value))
            index++
        }

        private fun multiply(register: String, value: String) {
            registers.set(register, registers.getValue(register) * resolve(value))
            index++
        }

        private fun modulo(register: String, value: String) {
            registers.set(register, registers.getValue(register) % resolve(value))
            index++
        }

        private fun jump(register: String, value: String) {
            if (resolve(register) > 0) {
                index += resolve(value).toInt()
            } else {
                index++
            }
        }

        private suspend fun receive(register: String) {
            index = withTimeoutOrNull(2000L) {
                val received = channels[id].receive()
                registers.set(register, received)
                index + 1
            }?: -1
        }

        private suspend fun send(register: String) {
            sendsPerChannel[id] = sendsPerChannel[id] + 1
            val message = resolve(register)
            channels[otherProgramId].send(message)
            index++
        }

        suspend fun run(instructions: List<String>) {
            while (index in 0 until instructions.size) {
                val instruction = Utils.toWords(instructions.get(index))

                when (instruction[0]) {
                    "snd" -> send(instruction[1])
                    "rcv" -> receive(instruction[1])
                    "set" -> set(instruction[1], instruction[2])
                    "add" -> add(instruction[1], instruction[2])
                    "mul" -> multiply(instruction[1], instruction[2])
                    "mod" -> modulo(instruction[1], instruction[2])
                    "jgz" -> jump(instruction[1], instruction[2])
                    else -> throw IllegalArgumentException("Invalid instruction $instruction")
                }
            }

            println("program $id; sends: ${sendsPerChannel[id]}")

        }
    }
}