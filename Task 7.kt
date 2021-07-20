/*Произведения цифр числа*/
/*
fun main(){
    try {
        val number = inputnumber()!!
        println("Произведение цифр числа: ${multDigit(number)}")
    }
    catch (e: Exception)
    {
        println("Exception")
        println(e.message)
    }
}


fun inputnumber(): Int? {
    print("Введите число:")
    val number = readLine()!!.toInt()
    return number
}

fun multDigit(number: Int): Int=
    if (number/10 == 0)
        number%10
    else
    multDigit(number/10) * (number%10)



/*Максимальная цифра числа*/

fun main(){
    try {
        val number = inputnumber()!!
        println("Максимальная цифра числа: ${maxDigit(number)}")
    }
    catch (e: Exception)
    {
        println("Exception")
        println(e.message)
    }
}

fun inputnumber(): Int? {
    print("Введите число:")
    val number = readLine()!!.toInt()
    return number
}

fun maxDigit(number: Int): Int {
    fun maxDigit(number: Int, max: Int): Int {
        var newNumber = number / 10
        var digit = number % 10
        val newMax =
            if (digit > max)
                digit
            else
                max

        return if (newNumber != 0)
            maxDigit(newNumber, newMax)
        else
            newMax
    }
    return maxDigit(number, -1)
}

/*Минимальная цифра числа*/
fun main(){
    try {
        val number = inputnumber()!!
        println("Минимальная цифра числа: ${minDigit(number)}")
    }
    catch (e: Exception)
    {
        println("Exception")
        println(e.message)
    }

}

fun inputnumber(): Int? {
    print("Введите число:")
    val number = readLine()!!.toInt()
    return number
}

fun minDigit(number: Int): Int {
    fun minDigit(number: Int, min: Int): Int {
        var newNumber = number / 10
        var digit = number % 10
        val newMin =
            if (digit < min)
                digit
            else
                min

        return if (newNumber != 0)
           minDigit(newNumber, newMin)
        else
            newMin
    }
    return minDigit(number, 9)
}
*/
