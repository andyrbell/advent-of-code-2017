class Day13Part1 {
    fun solve(input: List<String>): Int {

        val firewallLayers = input.map { Utils.toPair(it) }.toMap().withDefault { _ -> -1 }
        val maxDepth = firewallLayers.keys.max()!!

        fun packetPosition(time: Int): Int = time

        var totalSeverity = 0
        for (t in 0..maxDepth) {
            val packetPosition = packetPosition(t)
            val maxRange = firewallLayers.getValue(packetPosition)
            if (maxRange != -1 && 0 == (t % ((maxRange - 1) * 2))) {

                val severity = t * maxRange
                println("t=$t; severity=$severity")
                totalSeverity += severity
            }
        }

        return totalSeverity
    }

}