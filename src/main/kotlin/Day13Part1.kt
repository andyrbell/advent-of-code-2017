import Utils.toPair

class Day13Part1 {
    fun solve(input: List<String>): Int {

        val firewallLayers = input.map { toPair(it) }.toMap()

        return firewallLayers.entries
                .filter { (it.key % ((it.value - 1) * 2)) == 0 }
                .map { it.key * it.value }
                .sum()
    }

}