/*сумма цифр числа (хвостовая рекурсия) */

fun main(){
    val number = Inputnumber();
    println("Сумма цифр числа равна: ${sumOfDigitsTail(number)}")
}
fun Inputnumber(): Int {
    print("Введите число:")
    val number = readLine()!!.toString()
    return try {
        number.toInt()
    } catch (e: NumberFormatException) {
        Inputnumber()
    }
}
fun sumOfDigitsTail(number: Int, sum: Int): Int =
    if (number / 10 == 0)
sum + (number % 10)
else
sumOfDigitsTail(number / 10, sum + (number % 10))

fun sumOfDigitsTail(number: Int): Int =
    sumOfDigitsTail(number, 0) 
