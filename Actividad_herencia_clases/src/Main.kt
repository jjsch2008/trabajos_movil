import kotlin.math.PI
import kotlin.math.sqrt

fun main() {

    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacidad")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }

    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacidad")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet Length: %.2f".format(calculateMaxCarpetLength()))

        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
    }

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacidad")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet Length: %.2f".format(calculateMaxCarpetLength()))
    }
}

abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacidad: Int

    fun hasRoom(): Boolean {
        return residents < capacidad
    }

    fun getRoom() {
        if (hasRoom()) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }

    abstract fun floorArea(): Double
}

class SquareCabin(
    residents: Int,
    val length: Double
) : Dwelling(residents) {

    override val buildingMaterial = "Wood"
    override val capacidad = 6

    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(
    residents: Int,
    val radius: Double
) : Dwelling(residents) {

    override val buildingMaterial = "Straw"
    override val capacidad = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetLength(): Double {
        return sqrt(2.0) * radius
    }
}

class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2
) : RoundHut(residents, radius) {

    override val buildingMaterial = "Stone"
    override val capacidad= 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}
