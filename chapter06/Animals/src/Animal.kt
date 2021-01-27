abstract class Animal : Roamable{
    abstract val image : String
    abstract val food : String
    abstract val habitat : String
    var hunger = 10

    abstract fun makeNoise()

    abstract fun eat()

    override fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

class Hippo: Animal() { //Default constructor of abstract class MUST be called
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    //Use final to stop allowing functions and properties from being overwritten
    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }
}

abstract class Canine: Animal() {
    override fun roam() {
        println("The Canine is roaming")
    }
}

class Wolf: Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Hooooowl!")
    }

    override fun eat() {
        println("The Wolf is eating $food")
    }
}

class Vet {
    fun giveShot(animal: Animal) {
        //Code to do something medical
        animal.makeNoise()
    }
}

fun main(args: Array<String>) {
    val animals = arrayOf(Hippo(), Wolf())
    for (item in animals) {
        item.roam()
        item.eat()
    }

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()
    vet.giveShot(wolf)
    vet.giveShot(hippo)

    val vehicle = Vehicle()
    vehicle.roam()
    vehicle.roamMore() //Default implementation from interface
    println("Vehicle velocity ${vehicle.velocity}") //Property inherited from the interface
    vehicle.velocity = 60 //Interfaces have no backing fields, set operation can't be done
}