data class Recipe(
    val title: String,
    val mainIngredient: String,
    val isVegetarian: Boolean = false,
    val difficulty: String = "Easy" //Default parameter value, constructor can be called without this parameter
) {
    //val secondaryIngredient: String - WON'T be included in autogenerated functions (equals, hashcode, toString) as is not in constructor
}

class Mushroom(val size: Int, val isMagic: Boolean) { //Primary constructor
    constructor(isMagic_param: Boolean) : this(0, isMagic_param) { //Secondary constructor
        //Code that runs when the secondary constructor is called
    }
}

//@JvmOverloads - when will be called from Java
fun findRecipes( //Default values in functions
    title: String = "",
    ingredient: String = "",
    isVegetarian: Boolean = false,
    difficulty: String = ""
): Array<Recipe> {
    //Code to find recipes
    return arrayOf(Recipe(title, ingredient, isVegetarian, difficulty))
}

fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

fun addNumbers(a: Double, b: Double): Double { //Overloaded function
    return a + b
}

fun main(args: Array<String>) {
    val r1 = Recipe("Thai Curry", "Chicken")
    val r2 = Recipe(title = "Thai Curry", mainIngredient = "Chicken") //Using named arguments, does not require order
    val r3 = r1.copy(title = "Chicken Bhuna")
    println("r1 hash code: ${r1.hashCode()}")
    println("r2 hash code: ${r2.hashCode()}")
    println("r3 hash code: ${r3.hashCode()}")
    println("r1 toString: ${r1.toString()}")
    println("r1 == r2? ${r1 == r2}") //Calls equals, checks equivalence (values)
    println("r1.equals(r2)? ${r1.equals(r2)}")
    println("r1 === r2? ${r1 === r2}") //Checks reference to the same object
    println("r1 == r3? ${r1 == r3}")
    val (title, mainIngredient, vegetarian, difficulty) = r1 //ComponentN: Assigns the value of first property to title, second to mainIngredient, and so on
    println("title is $title and vegetarian is $vegetarian")
    val m1 = Mushroom(6, false) //Calls primary constructor
    println("m1 size is ${m1.size} and isMagic is ${m1.isMagic}")
    val m2 = Mushroom(true) //Calls secondary constructor
    println("m2 size is ${m2.size} and isMagic is ${m2.isMagic}")
    println(addNumbers(2, 5))
    println(addNumbers(1.6, 7.3))

    println(findRecipes(ingredient = "meat")[0])//Using named parameter and default values for the rest of them

    val recipes = arrayOf(r1, r2, r3)
    for ((title, mainIngredient) in recipes) //Destructured version, same as item and then item.title
        println("$title $mainIngredient")
}