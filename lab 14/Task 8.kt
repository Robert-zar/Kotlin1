 fun main(){
    val number = inputNumber()

    if (number != null) {
        Menu(number)
    }
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
        if (number / 10 == 0)
            (number % 10)
        else
            multDigits(number / 10) * (number % 10)




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


    fun minOfDigits(number: Int): Int {
        val newNumber = (number / 10)
        val digit = (number % 10)
        return if (newNumber != 0) {
            val min = minOfDigits(newNumber)
            if (digit < min)
                digit
            else min
        } else digit
    }

fun op(choice: String?): (Int) -> Int =
    when(choice) {
        "1" -> ::multDigits
        "2" -> ::maxOfDigitTail
        "3" -> ::minOfDigits
        else -> throw IllegalArgumentException("Неправильный номер функции")
    }

fun Menu(number: Int) {
    println("\nВыберите функцию для выполнения?\n")

    println("1: multDigits")
    println("2: maxOfDigitTail")
    println("3: minOfDigits")
    println("0: конец")

    print("Введите номер функции:")
    val choice = readLine()

    if (choice == "0")
        return

    try {
        println("Результат выполнения: ${op(choice)(number)}")
    }
    catch(e: IllegalArgumentException) {
        println("${e.message}! Введите еще раз!")
    }

    Menu(number)
}
