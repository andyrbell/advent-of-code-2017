import Utils.plus

class Day20Part1 {

    private val regex = """p=<([-\s]?\d+),([-\s]?\d+),([-\s]?\d+)>,\s+v=<([-\s]?\d+),([-\s]?\d+),([-\s]?\d+)>,\s+a=<([-\s]?\d+),([-\s]?\d+),([-\s]?\d+)>""".toRegex()

    fun solve(input: List<String>): Int {

        val particles = input.map { parse(it) }

        repeat(1000, {
            particles.forEach { it.move() }
        })

        return particles.indexOf(particles.minBy { it.distance() })
    }

    fun parse(line: String): Particle {

        println(line)
        val (px, py, pz, vx, vy, vz, ax, ay, az) = regex.find(line)!!.destructured

        return Particle(
                Triple(px.trim().toInt(), py.trim().toInt(), pz.trim().toInt()),
                Triple(vx.trim().toInt(), vy.trim().toInt(), vz.trim().toInt()),
                Triple(ax.trim().toInt(), ay.trim().toInt(), az.trim().toInt())
        )
    }

    data class Particle(var position: TripInt, var velocity: TripInt, var acceleration: TripInt) {
        fun distance() = Math.abs(position.first) + Math.abs(position.second) + Math.abs(position.third)

        fun move() {
            velocity = velocity.plus(acceleration)
            position = position.plus(velocity)
        }
    }
}