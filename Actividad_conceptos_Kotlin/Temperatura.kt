fun main() {

    printFinalTemperature(27.0, "Celsius", "Fahrenheit")
    printFinalTemperature(350.0, "Kelvin", "Celsius")
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin")

}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String
) {

    var finalMeasurement = 0.0

    if (initialUnit == "Celsius" && finalUnit == "Fahrenheit") {
        finalMeasurement = (9.0 / 5.0) * initialMeasurement + 32

    } else if (initialUnit == "Kelvin" && finalUnit == "Celsius") {
        finalMeasurement = initialMeasurement - 273.15

    } else if (initialUnit == "Fahrenheit" && finalUnit == "Kelvin") {
        finalMeasurement = (5.0 / 9.0) * (initialMeasurement - 32) + 273.15
    }

    val resultado = String.format("%.2f", finalMeasurement)

    println("$initialMeasurement grados $initialUnit son $resultado grados $finalUnit.")
}