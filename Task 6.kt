/*Найти сумму цифр числа*/

fun main() {
   try {
        val number = sumNumber()!!

            println("Сумма цифр числа: ${sumofDigits(number)}")

    }
   catch(e: Exception)
   {
       println("Exception")
       println(e.message)
   }
}
fun sumNumber(): Int? {
    print("Введите число: ")
    val number = readLine()!!.toInt()
    return number


}

    fun sumofDigits(number: Int): Int =
        if
            (number / 10 == 0)
            number % 10

    else
            sumofDigits(number / 10) + (number % 10)

