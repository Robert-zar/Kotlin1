import java.io.File

fun main(){
    val array = inputArray()
    print("Результат: ")
    outputArray<Int>(array)
}

fun<T> outputArray(array: Array<T>) {
    print("${array.joinToString(" ")}")
}

fun inputArrayConsole(): Array<Int> {
    print("Входной массив:")

    return try {
        readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    }
    catch(e: NumberFormatException) {
        println()
        inputArrayConsole()
    }
}

fun inputArrayFile(): Array<Int> =
    try {
        File("PathToArray.txt").readText().split(" ").map { it.toInt() }.toTypedArray()
    }
    catch(e: NullPointerException) { throw e }
    catch(e: java.io.FileNotFoundException) { throw e }
    catch(e: NumberFormatException) { throw e }


fun ArrayInputMethod(): () -> Array<Int> {
    println("Как вы хотите ввести массив?")
    println("1. С клавиатуры")
    println("2. Из файла")
    print("Вариант:")


    return when(readLine()) {
        "1" -> {
            println()
            ::inputArrayConsole
        }
        "2" -> ::inputArrayFile
        else -> {
            println("Выбран неверный метод. Введите ещё раз!")
            ArrayInputMethod()
        }
    }
}

fun inputArray(): Array<Int> {
    return try {
        ArrayInputMethod()()
    }
    catch(e: Exception) {
        when(e) {
            is NullPointerException, is java.io.FileNotFoundException -> {
                println("Ошибка: ${e.message}! Выберите консоль.\n")
                inputArray()
            }
            is NumberFormatException -> {
                println("Ошибка: ${e.message}! Проверить файл.\n")
                inputArray()
            }
            else -> throw e
        }
    }
}