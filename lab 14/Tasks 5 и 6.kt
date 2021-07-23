fun main(){
    val number=inputNumber()
    
       // task6
    /* считает сумму цифр, если каждая из них больше 3 */
    // calculateCondition(number, ::sumDigitsTail, ::checkDigits)

    /* считает произведение цифр, если каждая из них больше 5 */
    // calculateCondition(number, ::multDigitsTail, ::checkDigits, 1)
}

fun inputNumber(): Int {
    print("Введите число: ")
    val number = readLine()!!.toString()

    return try {
        number.toInt()
    }
    catch (e: NumberFormatException) {
        inputNumber()
    }
}
fun calculate(number: Int, func: (number: Int) -> Int, initValue: Int = 0): Int =
    func(number)
fun calculateCondition(number: Int, FunCalculate: (number: Int, value: Int) -> Int, FunCondition: (number: Int) -> Boolean, initValue: Int = 0) {
    if (FunCondition(number))
        println("Результат функции: ${FunCalculate(number, initValue)}")
    else
        println("Цифры не удовлетворяют условию!")
}


fun checkDigits(number: Int): Boolean =
    if (number % 10 > 3) {
        if (number / 10 == 0)
            true
        else
            checkDigits(number / 10)
    }
    else false

fun sumDigitsTail(number: Int, sum: Int): Int =
    if (number / 10 == 0)
        sum + (number % 10)
    else
        sumDigitsTail(number / 10, sum + (number % 10))

fun sumDigitsTail(number: Int): Int =
    sumDigitsTail(number, 0)

/* fun multDigitsTail(number: Int, mult: Int): Int =
    if (number / 10 == 0)
        mult * (number % 10)
    else
        multDigitsTail(number / 10, mult * (number % 10))

fun multDigitsTail(number: Int): Int =
    multDigitsTail(number, 1) */
