
/* fun main(){
        val number = inputnumber();
    println("Сумма цифр числа равна: ${sumOfDigits(number)}")
}
fun inputnumber(): Int {
    print("Введите число:")
    val number = readLine()!!.toString()
    return try {
        number.toInt()
    } catch (e: NumberFormatException) {
        inputnumber()
    }
}
fun sumOfDigits(number: Int): Int =
    if (number/10 == 0)
        (number%10)
else sumOfDigits(number/10) + (number%10) */