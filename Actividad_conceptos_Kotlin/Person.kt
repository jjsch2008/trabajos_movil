fun main() {    
    val amanda = Person("Amanda", 33, "jugar tenis", null)
    val atiqah = Person("Atiqah", 28, "escalar", amanda)
    
    amanda.showProfile()
    println()
    atiqah.showProfile()
}


class Person(
    val name: String,
    val age: Int,
    val hobby: String?,
    val referrer: Person?
) {

    fun showProfile() {

        println("Nombre: $name")
        println("Edad: $age")

        if (hobby != null) {
            print("Le gusta $hobby. ")
        }

        if (referrer == null) {
            println("No tiene persona que lo haya referido.")
        } else {
            println("Fue referido por ${referrer.name}, a quien le gusta ${referrer.hobby}.")
        }
    }
}