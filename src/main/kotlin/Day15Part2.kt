import Utils.toBitString

class Day15Part2 {
    fun solve(aSeed: Long, bSeed: Long): Long {

        val generatorA = generateSequence(aSeed) { (it * 16807) % 2147483647 }.drop(1).filter { it % 4 == 0L }
        val generatorB = generateSequence(bSeed) { (it * 48271) % 2147483647 }.drop(1).filter { it % 8 == 0L }

        return generatorA.zip(generatorB).take(5_000_000)
                .count {
                    toBitString(it.first).takeLast(16) == toBitString(it.second).takeLast(16)
                }.toLong()
    }
}

