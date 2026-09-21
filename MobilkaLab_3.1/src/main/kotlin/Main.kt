package org.example
import java.io.PrintStream

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

    val procesNum: String = userNum.toString()
    val result: Int = procesNum.first().digitToInt() + procesNum.last().digitToInt()

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