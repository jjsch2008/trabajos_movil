class Phone(var isScreenLightOn: Boolean = false){

    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "encendida" else "apagada"
        println("La pantalla del teléfono está $phoneScreenLight.")
    }
}


class FoldablePhone(
    var isFolded: Boolean = true
) : Phone() {

    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }

    fun fold() {
        isFolded = true
        isScreenLightOn = false
    }

    fun unfold() {
        isFolded = false
    }
}
