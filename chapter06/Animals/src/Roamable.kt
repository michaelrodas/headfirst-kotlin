interface Roamable {
    var velocity: Int
        get() = 20
        set(value) {
            println("Unable to update velocity")
        }
    fun roam()

    fun roamMore() { //Even with default implementation can still be overridden
        println("Roam way more!")
    }
}