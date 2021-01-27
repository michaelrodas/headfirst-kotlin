class Wolf {
    var hunger = 10
    val food = "meat"

    fun eat() {
        println("The Wolf is eating $food")
    }
}



class MyWolf {
    var wolf: Wolf? = Wolf() //Declared as Nullable

    fun myFunction() {
        wolf?.eat()
    }
}




fun getAlphaWolf(): Wolf? { //May return null
    return Wolf()
}




fun main(args: Array<String>) {
    var w: Wolf? = Wolf()

    w?.eat() //Replaces if not null expression

    var x = w?.hunger //Safe call, hunger is invoked only if w is not null
    println("The value of x is $x")

    var y = w?.hunger ?: -1
    println("The value of y is $y")

    var myWolf = MyWolf()
    myWolf?.wolf?.hunger = 8 //Chained safe calls
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    var myArray = arrayOf("Hi", "Hello", null)
    for (item in myArray) {
        item?.let { println(it) } //Print "it" (the item) only when is not null
    }

    getAlphaWolf()?.let { it.eat() }

    //w = null
    var z = w!!.hunger //Throws NullPointer if w is null
}