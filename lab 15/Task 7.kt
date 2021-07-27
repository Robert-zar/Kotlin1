 import java.io.File

fun main(){
    val list = inputList()
    print("Результат: ")
    outputList<Int>(list)
}

fun<T> outputList(list: List<Int>) {
    print("${list.joinToString(" ")}")
}

fun inputListConsole(): List<Int> {
    print("Входной список: ")

    return try {
        readLine()!!.split(" ").map { it.toInt() }
    }
    catch(e: NumberFormatException) {
        println()
        inputListConsole()
    }
}

fun inputListFile(path: String = "PathToList.txt"): List<Int> =
    try {
        File(path).readText().split(" ").map { it.toInt() }
    }
    catch(e: NullPointerException) { throw e }
    catch(e: java.io.FileNotFoundException) { throw e }
    catch(e: NumberFormatException) { throw e }


fun ListInputMethod(): () -> List<Int> {
    println("Как вы хотите ввести список?")
    println("1. С клавиатуры")
    println("2. Из файла")
    print("Вариант: ")

    return when(readLine()) {
        "1" -> {
            println()
            ::inputListConsole
        }
        "2" -> ::inputListFile
        else -> {
            println("Выбран неверный метод. Введите ещё раз!")
            ListInputMethod()
        }
    }
}



fun inputList(): List<Int> {
    return try {
       ListInputMethod()()
    }
    catch(e: Exception) {
        when(e) {
            is NullPointerException, is java.io.FileNotFoundException -> {
                println("Ошибка: ${e.message}! Выберите консоль.\n")
                inputList()
            }
            is NumberFormatException -> {
                println("Ошибка: ${e.message}! Проверить файл.\n")
                inputList()
            }
            else -> throw e
        }
    }
}
