typealias DoubleConversion = (Double) -> Double //Provides a name to a function type

fun convert(
    x: Double,
    converter: DoubleConversion //Lambda as parameter
): Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun getConversionLambda(str: String): DoubleConversion { //Higher order function, receives or returns a lambda
    when (str) { //Replaces cascade of if
        "CentigradeToFahrenheit" -> {
            return { it * 1.8 + 32 } //Lambda as return
        }
        "KgsToPounds" -> {
            return { it * 2.204623 }
        }
        "PoundsToUSTons" -> {
            return { it / 2000.0 }
        }
        else -> {
            return { it }
        }
    }
}

fun combine(
    lambda1: DoubleConversion,
    lambda2: DoubleConversion
): DoubleConversion {
    return { x: Double -> lambda2(lambda1(x)) }
}

fun main(args: Array<String>) {
    val addFive = {x: Int -> x + 5}
    println("Pass 6 to addFive: ${addFive(6)}")

    val addInts = {x: Int, y: Int -> x + y}
    val result = addInts.invoke(6,7) //Long way of invocation
    val result2 = addInts(6,7) //Short way of invocation
    println("Pass 6 and 7 to addInts: $result2")

    val intLambda: (Int, Int) -> Int = { x, y -> x * y} //With function type declaration
    println("Pass 5 and 6 to intLambda: ${intLambda(5,6)}")

    val addSeven: (Int) -> Int = { it + 7} //Compiler can infer type so "it" can be used
    println("Pass 12 to addSeven: ${addSeven(12)}")

    val myLambda: () -> Unit = { println("Hi")} //Unit because it has no return
    myLambda()

    //Convert 2.5kg to Pounds
    println("Convert 2.5kg to Pounds: ${getConversionLambda("KgsToPounds")(2.5)}")

    //Define two conversion lambdas
    val kgsToPoundsLambda = getConversionLambda("KgsToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")

    //Combine the two lambdas to create a new one
    val kgsToUSTonsLambda = combine(kgsToPoundsLambda, poundsToUSTonsLambda)

    //Use the new lambda to convert 17.4 to US tons
    val value = 17.4
    println("$value kgs is ${convert(value, kgsToUSTonsLambda)} US tons")

    println("Calling convert: ${convert(20.0) { it * 1.8 + 32 }}") //Same as convert(20.0, {it * 1.8 + 32})
}