object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        if (rows == 0) return emptyList()
        val triangle = mutableListOf(listOf(1))
        if (rows == 1) return triangle
        for (i in 1 until rows) {
            triangle.add(nextRowFromPrevious(triangle[i-1]))
        }
        return triangle
    }

    private fun nextRowFromPrevious(previousRow: List<Int>): List<Int> {
        var prevNumber = 0
        val newRow = mutableListOf<Int>()
        for (n in previousRow) {
            newRow.add(prevNumber + n)
            prevNumber = n
        }
        newRow.add(prevNumber + 0) // To take care of the last one
        return newRow
    }
}
