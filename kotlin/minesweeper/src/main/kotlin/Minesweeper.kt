import kotlin.math.abs

data class MinesweeperBoard(val inputBoard: List<String>) {

    private val matrix : List<MutableList<String>> = inputBoard.map { line -> line.map { it.toString() }.toMutableList() }
    private val STAR = "*"

    fun withNumbers(): List<String> {
        for (i in matrix.indices) {
           for (j in matrix[0].indices) {
               if (matrix[i][j] != STAR) {
                   val numNeighbours = findNumNeighbours(matrix, i, j)
                   if (numNeighbours != 0) {
                       matrix[i][j] = numNeighbours.toString()
                   }
               }
           }
        }
        return matrix.map { it.joinToString("") }
    }

    private fun findNumNeighbours(matrix: List<List<String>>, row: Int, col: Int): Int {
        var neighboursToCheck = mutableListOf<Pair<Int, Int>>()
        for (i in -1..1) {
            for (j in -1..1) {
                if (i == 0 && j == 0) continue
                if (row + i < 0 || row + i >= matrix.size) continue
                if (col + j < 0 || col + j >= matrix[0].size) continue
                neighboursToCheck.add(Pair(row + i, col + j))
            }
        }
        var numNeighbourStars = 0
        for ((i, j) in neighboursToCheck) {
            if (matrix[i][j] == STAR) {
                numNeighbourStars++
            }
        }
        return numNeighbourStars
    }
}
