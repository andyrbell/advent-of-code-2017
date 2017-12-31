import Utils.Matrix
import Utils.join

object Day21Part1 {
    fun generateRules(lines: List<String>): Map<Matrix, Matrix> {
        return lines.map {
            val rule = it.split(" => ")
            val input = Matrix(rule[0].split("/"))
            val output = Matrix(rule[1].split("/"))
            input.allTransforms().associateBy({ it }, { _ -> output})
        }.fold(mutableMapOf(), { acc, map -> acc.putAll(map); acc})
    }

    fun solve(input: List<String>, iterations: Int): Int {
        val ruleBook = generateRules(input)

        val initial = Matrix(".#./..#/###".split("/"))

        return fractals(initial, ruleBook, iterations)
    }

    tailrec fun fractals(matrix: Matrix, ruleBook: Map<Matrix, Matrix>, iterations: Int): Int {
        println(matrix)
        return if (iterations == 0) {
            matrix.count()
        } else {
            val next = matrix.split()
                    .toList()
                    .map {
                        val rule = ruleBook.getValue(it)
                        rule
                    }
                    .join()
            fractals(next, ruleBook, iterations - 1)
        }
    }
}