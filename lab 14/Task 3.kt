/* Произведение цифр числа. Рекурсия вверх */
fun main(){
    val number = inputNumber();
    println("Произведение цифр числа равна: ${multDigits(number)}")
}
fun inputNumber(): Int {
    print("Введите число:")
    val number = readLine()!!.toString()
    return try {
        number.toInt()
    } catch (e: NumberFormatException) {
        inputNumber()
    }
}
fun multDigits(number: Int): Int =
    if (number/10 == 0)
        (number%10)
else
    multDigits(number/10) * (number%10)
    

/* Произведение цифр числа. Хвостовая рекурсия */
 fun main(){
    val number = inputNumber();
    println("Произведение цифр числа: ${multDigitsTail(number)}")
}
fun inputNumber(): Int {
    print("Введите число:")
    val number = readLine()!!.toString()
    return try {
        number.toInt()
    } catch (e: NumberFormatException) {
        inputNumber()
    }
}
fun multDigitsTail(number: Int, mult: Int): Int =
    if (number / 10 == 0)
mult * (number % 10)
else
multDigitsTail(number / 10, mult * (number % 10))

fun multDigitsTail(number: Int): Int =
    multDigitsTail(number, 1) 
    

/*Максимальная цифра числа. Рекурсия вверх*/
 fun main(){
    val number = inputNumber();
    println("Максимальная цифра числа: ${maxOfDigit(number!!)}")
}
fun inputNumber(): Int? {
    print("Введите число:")
    val number = readLine()!!.toInt()
    return number
}
fun maxOfDigit(number: Int): Int {
    val newNumber = number / 10
    val digit = (number % 10)

    return if (newNumber != 0) {
        val max = maxOfDigit(newNumber)
        if (digit > max)
        digit
        else max
    }
    else digit
} 


/*Максимальная цифра числа. Хвостовая рекурсия*/
 fun main(){
    val number = inputNumber();
    println("Максимальная цифра числа: ${maxOfDigitTail(number!!)}")
}
fun inputNumber(): Int? {
    print("Введите число:")
    val number = readLine()!!.toInt()
    return number
}
fun maxOfDigitTail(number: Int): Int {
    fun maxOfDigitTail(number: Int, max: Int): Int {
        val newNumber = number / 10
        val digit = (number % 10)

        val newMax =
            if (digit > max)
        digit
        else max

                return if (newNumber != 0)
                    maxOfDigitTail(newNumber, newMax)
                else newMax
    }
    return maxOfDigitTail(number, -1)
} 


/* Минимальная цифра числа. Рекурсия вверх */
 fun main(){
    val number = inputNumber();
 println("Минимальная цифра числа ${number?.let { minOfDigits(it) }}")
}
fun inputNumber(): Int? {
    print("Введите число:")
    val number = readLine()!!.toInt()
    return number
}
fun minOfDigits(number: Int): Int {
    val newNumber = (number/10)
    val digit = (number%10)
    return if (newNumber != 0) {
        val min = minOfDigits(newNumber)
        if (digit < min)
            digit
        else min
    }
    else digit
} 


 /* Минимальная цифра числа. Хвостовая рекурсия */
 fun main(){
    val number = inputNumber();
    println("Минимальная цифра числа ${number?.let { minOfDigitsTail(it) }}")
}
fun inputNumber(): Int? {
    print("Введите число:")
    val number = readLine()!!.toInt()
    return number
}
fun minOfDigitsTail(number: Int): Int {
    fun minOfDigitsTail(number: Int, min: Int): Int {
        val newNumber = (number / 10)
        val digit = (number % 10)
        val newMin =
     if (digit<min)
         digit
        else min
        return if (newNumber != 0)
            minOfDigitsTail(newNumber, newMin)
        else newMin
    }
    return minOfDigitsTail(number, 9)
} 
