object Sieve {

    fun primesUpTo(upperBound: Int): List<Int> {
        if (upperBound < 2) return emptyList()

        // Go through every number, if it isn't in the bad set, add it to the primeList and
        // add all of it's multiples to the bad set
        val discardSet = mutableSetOf<Int>()
        val primeList = mutableListOf<Int>()
        for (i in 2..upperBound) {
            if (i in discardSet) continue
            else primeList.add(i)
            for (j in i..upperBound step i) {
                discardSet.add(j)
            }
        }

        return primeList
    }
}
