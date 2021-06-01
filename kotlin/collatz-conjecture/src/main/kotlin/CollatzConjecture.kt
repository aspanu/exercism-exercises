object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start <= 0) {
            throw IllegalArgumentException()
        }
        var currentNumber = start
        var steps = 0
        while (currentNumber != 1) {
            if (currentNumber % 2 == 0) {
                currentNumber /= 2
            } else {
                currentNumber = (3 * currentNumber) + 1
            }
            steps++
        }
        return steps
    }
}
