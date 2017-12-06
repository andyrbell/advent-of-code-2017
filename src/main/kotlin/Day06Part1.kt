class Day06Part1 {
    fun solve(input: IntArray): Int {
        val seen = hashSetOf(input.toList().toString())
        val memory = input.copyOf()

        val index = memory.indexOf(memory.max()!!)
        val stack = memory[index]
        memory[index] = 0
        return solve(stack, index, memory, seen)
    }

    private tailrec fun solve(stack: Int, index: Int, memory: IntArray, seen: HashSet<String>): Int {
        val updatedMemory = reallocate(stack, index + 1, memory)
        val added = seen.add(updatedMemory.toList().toString())
        return when (added) {
            false -> seen.size
            true -> {
                val newIndex = memory.indexOf(memory.max()!!)
                val newStack = memory[newIndex]
                memory[newIndex] = 0
                solve(newStack, newIndex, updatedMemory, seen)
            }
        }
    }

    private tailrec fun reallocate(stack: Int, index: Int, memory: IntArray) : IntArray {
        return when (stack) {
            0 -> memory
            else -> {
                memory[index % memory.size]++
                reallocate(stack - 1, index + 1, memory)
            }
        }
    }
}