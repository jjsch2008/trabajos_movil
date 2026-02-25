class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {

    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, interpretada por $artist, se lanzó en $yearPublished.")
    }
}


fun main() {

    val song1 = Song("Shape of You", "Ed Sheeran", 2017, 1500)
    val song2 = Song("Canción Nueva", "Artista Indie", 2023, 500)

    song1.printDescription()
    println("¿Es popular? ${song1.isPopular}")

    println()

    song2.printDescription()
    println("¿Es popular? ${song2.isPopular}")
}