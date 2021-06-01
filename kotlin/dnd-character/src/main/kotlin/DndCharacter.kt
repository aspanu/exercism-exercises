import kotlin.math.floor
import kotlin.random.Random

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        fun ability(): Int {
            // Pick 4 random numbers from 1-6 (dice roll),
            // discard the smallest one and add the rest together
            val rolledNumbers = mutableListOf<Int>()
            var smallestNumber = 7
            for (i in 1..4) {
                val roll = Random.nextInt(1, 7)
                if (roll < smallestNumber) smallestNumber = roll
                rolledNumbers.add(roll)
            }

            return rolledNumbers.sum() - smallestNumber
        }

        fun modifier(score: Int): Int {
            return floor((score - 10) / 2.0).toInt()
        }
    }
}
