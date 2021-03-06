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
                Triple(px.trim().toLong(), py.trim().toLong(), pz.trim().toLong()),
                Triple(vx.trim().toLong(), vy.trim().toLong(), vz.trim().toLong()),
                Triple(ax.trim().toLong(), ay.trim().toLong(), az.trim().toLong())
        )
    }

    data class Particle(var position: TripLong, var velocity: TripLong, var acceleration: TripLong) {
        fun distance() = Math.abs(position.first) + Math.abs(position.second) + Math.abs(position.third)

        fun move() {
            velocity = velocity.plus(acceleration)
            position = position.plus(velocity)
        }
    }
}