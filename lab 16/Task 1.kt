
 fun main() {
    print("Ввод: ")
    val s = readLine()!!.toString()

    maxNumber()
}
fun maxNumber() {
    print("Ввод: ")
    val s = readLine()

    try {
        val listNumbers = s!!.split(" ").map { it.toInt() }
        println("Максимальное число: ${listNumbers.maxOrNull()}")

    }
    catch(e: NumberFormatException) {
        println("Ошибка: ${e.message}. Попробуй еще раз!\n")
        maxNumber()
    }
} 
