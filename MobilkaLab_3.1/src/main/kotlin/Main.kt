package org.example
import java.io.PrintStream
import kotlin.math.sqrt

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))
    print("Please enter task num in range 1-10: ")
    var taskNumber: Int = readln().toInt()
    while (taskNumber !in 1..10){
        print("Please enter correct task num: ")
        taskNumber= readln().toInt()

    }

    when(taskNumber){
        1 -> task1()
        2 -> task2()
        3 -> task3()
        4 -> task4()
        5 -> task5()
        6 -> task6()
        7 -> task7()
        8 -> task8()
        9 -> task9()
        10 -> task10()
    }
}

fun task1() {
    println("Please enter a positive integer: ")
    var userNum: Int = readln().toInt()
    while (userNum < 0) {
        print(
            "Warning: This is not a positive integer.\n" +
                    "Please enter a positive integer: "
        )
        userNum = readln().toInt()
    }

    val processNum: String = userNum.toString()
    val result: Int = processNum.first().digitToInt() + processNum.last().digitToInt()

    print("Result of sum: $result")

}

fun task2() {
    var userNum: Double = readln().toDouble()
    var count: Int = 0
    var result: Double = 0.0

    while (userNum != 0.0 ){
        ++count
        result += userNum
        userNum = readln().toDouble()
    }
    if (count > 0) {
        print("Count: $count \nSum: $result \nArithmetic mean: ${result / count.toDouble()}")
    } else {
        print("Count: 0 \nSum: 0.0 \nArithmetic mean: 0.0")
    }
}

fun task3() {
    var roboNum: Int = (1..10).random()
    var UserNum: Double = readln().toDouble()

    if (UserNum > roboNum) {
        print("Много\n")
        roboNum = (1..10).random()
        UserNum= readln().toDouble()

    } else if (UserNum < roboNum){
        print("Мало\n")
        roboNum = (1..10).random()
        UserNum= readln().toDouble()
    } else {
        print("Угадал\n")
    }
}

fun task4(){
    print("Please enter last simple num: ")
    var userNum: Int = readln().toInt()

    while (userNum <= 1){
        print("Warning: Please enter number more one: ")
        userNum = readln().toInt()
    }

    for (indexI: Int in 2..userNum){
        if (isPrime(indexI)){
            println("$indexI")
        }
    }

}

fun isPrime(num: Int): Boolean {
    if (num <= 1) {
        return false
    }

    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

fun task5() {
    val myMassive = arrayOf<Int>(1, 4, 2, 7, 5)

    print("What do you want to use?\n" +
            "for - 1\n" +
            "while - 2\n" +
            "forEach - 3\n")

    var userNum: Int = readln().toInt()

    while(userNum !in 1..3){
        print("Please enter the number in range 1-3: ")
        userNum = readln().toInt()
    }

    fun task51(myMassive: Array<Int>){
        for (index: Int in 1..<myMassive.lastIndex){
            if (myMassive[index] > myMassive[index - 1] and myMassive[index + 1]){
                print("${myMassive[index]}\n")
            }
        }
    }

    fun task52(myMassive: Array<Int>){
        var index: Int = 1

        while(index < myMassive.lastIndex){
            if (myMassive[index] > myMassive[index - 1] && myMassive[index] > myMassive[index + 1]){
                print("${myMassive[index]}\n")
            }
            ++index
        }
    }

    fun task53(myMassive: Array<Int>){
        myMassive.forEachIndexed { index, currentElement ->
            if (index > 0 && index < myMassive.lastIndex) {
                if (currentElement > myMassive[index - 1] && currentElement > myMassive[index + 1]) {
                    println(currentElement)
                }
            }
        }
    }

    when(userNum){
        1 -> task51(myMassive)
        2 -> task52(myMassive)
        3 -> task53(myMassive)
    }
}

fun task6() {
    val myMassive = arrayOf(2, 3, 5, 4)

    print("What do you want to use?\n" +
            "for - 1\n" +
            "while - 2\n" +
            "forEach - 3\n" +
            "reduce() - 4\n" +
            "min() / max() - 5\n")

    var userNum = readln().toInt()

    while (userNum !in 1..5) {
        print("Please enter the number in range 1-5: ")
        userNum = readln().toInt()
    }

    fun task61(arr: Array<Int>) {
        var product = 1
        var min = arr[0]
        var max = arr[0]

        for (num in arr) {
            product *= num
            if (num < min) min = num
            if (num > max) max = num
        }
        println("Product: $product, Min: $min, Max: $max")
    }

    fun task62(arr: Array<Int>) {
        var product = 1
        var min = arr[0]
        var max = arr[0]
        var index = 0

        while (index < arr.size) {
            val num = arr[index]
            product *= num
            if (num < min) min = num
            if (num > max) max = num
            index++
        }
        println("Product: $product, Min: $min, Max: $max")
    }

    fun task63(arr: Array<Int>) {
        var product = 1
        var min = arr[0]
        var max = arr[0]

        arr.forEach { num ->
            product *= num
            if (num < min) min = num
            if (num > max) max = num
        }
        println("Product: $product, Min: $min, Max: $max")
    }

    fun task64(arr: Array<Int>) {
        val product = arr.reduce { acc, num -> acc * num }

        val min = arr.reduce { acc, num -> if (num < acc) num else acc }
        val max = arr.reduce { acc, num -> if (num > acc) num else acc }

        println("Product: $product, Min: $min, Max: $max")
    }

    fun task65(arr: Array<Int>) {
        val product = arr.reduce { acc, num -> acc * num }

        val min = arr.minOrNull()
        val max = arr.maxOrNull()

        println("Product: $product, Min: $min, Max: $max")
    }

    when (userNum) {
        1 -> task61(myMassive)
        2 -> task62(myMassive)
        3 -> task63(myMassive)
        4 -> task64(myMassive)
        5 -> task65(myMassive)
    }
}

fun task7() {
    println("Solving the quadratic equation: ax^2 + bx + c = 0")
    print("Enter coefficient a: ")
    val a = readln().toDouble()
    print("Enter coefficient b: ")
    val b = readln().toDouble()
    print("Enter coefficient c: ")
    val c = readln().toDouble()

    quadraticRoot(a, b, c)
}

fun sqr(n: Double): Double {
    return n * n
}

fun discriminant(a: Double, b: Double, c: Double): Double {
    return sqr(b) - 4 * a * c
}

fun rootsNumber(a: Double, b: Double, c: Double): Int {
    val dis = discriminant(a, b, c)
    return when {
        dis > 0.0 -> 2
        dis == 0.0 -> 1
        else -> 0
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double) {
    val d = discriminant(a, b, c)
    val count = rootsNumber(a, b, c)

    when (count) {
        2 -> {
            val x1 = (-b + Math.sqrt(d)) / (2 * a)
            val x2 = (-b - Math.sqrt(d)) / (2 * a)
            println("The equation has 2 roots: x1 = $x1, x2 = $x2")
        }
        1 -> {
            val x = -b / (2 * a)
            println("The equation has 1 root: x = $x")
        }
        0 -> {
            println("The equation has no real roots (D < 0)")
        }
    }
}


fun task8() {
    class NumberArray(val numbers: Array<Int>) {

        fun sumPositive(): Int {
            var totalSum = 0
            for (element in numbers) {
                if (element > 0) totalSum += element
            }
            return totalSum
        }

        fun product(): Int {
            var productResult = 1
            for (element in numbers) {
                productResult *= element
            }
            return productResult
        }

        fun average(): Double {
            var totalSum = 0.0
            for (element in numbers) {
                totalSum += element
            }
            return totalSum / numbers.size
        }
    }

    print("Enter massive size: ")
    var arraySize = readln().toInt()

    while (arraySize <= 0) {
        println("Size must be more than 0.")
        arraySize = readln().toInt()
    }

    val array = Array(arraySize) { 0 }

    println("Enter the element of massive:")
    for (index in 0 until arraySize) {
        array[index] = readln().toInt()
    }

    val arrayHandler = NumberArray(array)

    val positiveSum = arrayHandler.sumPositive()
    val totalProduct = arrayHandler.product()
    val averageValue = arrayHandler.average()

    print("Positive sum: $positiveSum")
    print("Multiplication: $totalProduct")
    print("Average value: $averageValue")
}

class Vector(val xCoord: Double, val yCoord: Double, val zCoord: Double) {

    fun length(): Double {
        return sqrt(xCoord * xCoord + yCoord * yCoord + zCoord * zCoord)
    }

    fun dotProduct(otherVector: Vector): Double {
        return (this.xCoord * otherVector.xCoord) +
                (this.yCoord * otherVector.yCoord) +
                (this.zCoord * otherVector.zCoord)
    }

    infix fun dot(otherVector: Vector): Double {
        return this.dotProduct(otherVector)
    }

    operator fun times(otherVector: Vector): Double {
        return this.dotProduct(otherVector)
    }
}

fun calculateExternalDotProduct(firstVector: Vector, secondVector: Vector): Double {
    return firstVector.dotProduct(secondVector)
}

fun task9() {
    val vectorFirst = Vector(1.0, 2.0, 3.0)
    val vectorSecond = Vector(3.0, 2.0, 1.0)

    println("Length of first vector: ${vectorFirst.length()}")

    val standardResult = vectorFirst.dotProduct(vectorSecond)
    println("Standard dot product: $standardResult")

    val infixResult = vectorFirst dot vectorSecond
    println("Infix dot product: $infixResult")

    val operatorResult = Vector(1.0, 2.0, 3.0) * Vector(3.0, 2.0, 1.0)
    println("Operator '*' dot product: $operatorResult")

    val externalResult = calculateExternalDotProduct(vectorFirst, vectorSecond)
    println("External function dot product: $externalResult")
}

open class Vehicle {
    open val vehicleName: String = "Generic Vehicle"
    open val movementSpeed: Int = 0

    open fun start() {
        println("$vehicleName started moving at a speed of $movementSpeed km/h.")
    }

    open fun stop() {
        println("$vehicleName has stopped.")
    }
}

class Boat : Vehicle() {
    override val vehicleName: String = "The boat"
    override val movementSpeed: Int = 30

    override fun start() {
        println("$vehicleName started sailing at a speed of $movementSpeed km/h.")
    }

    override fun stop() {
        println("$vehicleName dropped anchor and stopped.")
    }
}

class Plane : Vehicle() {
    override val vehicleName: String = "The plane"
    override val movementSpeed: Int = 800

    override fun start() {
        println("$vehicleName took off and started flying at a speed of $movementSpeed km/h.")
    }

    override fun stop() {
        println("$vehicleName landed and stopped.")
    }
}

class Tank : Vehicle() {
    override val vehicleName: String = "The tank"
    override val movementSpeed: Int = 60

    override fun start() {
        println("$vehicleName started rolling at a speed of $movementSpeed km/h.")
    }

    override fun stop() {
        println("$vehicleName ground to a halt and stopped.")
    }
}

fun task10() {
    val currentBoat = Boat()
    val currentPlane = Plane()
    val currentTank = Tank()

    currentBoat.start()
    currentBoat.stop()
    println()

    currentPlane.start()
    currentPlane.stop()
    println()

    currentTank.start()
    currentTank.stop()
}
