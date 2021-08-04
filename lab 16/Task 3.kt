  import java.io.File
import java.util.zip.DataFormatException

fun main() {
    print("Ввод: ")
    val s = readLine()!!.toString()
    val text = File("Путь").readText()
     println("Dates (check file 'task3_example.txt'):\n")
     outputList<String>(findDates(text),"\n")
}
fun<T> outputList(list: List<T>, separator: String) {
    tailrec fun<T> outputList(it: Iterator<T>, separator: String) {
        if (it.hasNext()) {
            print("${it.next()}${separator}")
            outputList(it, separator)
        }
    }
    outputList(list.iterator(), separator)
}

fun findDates(s: String): List<String> {
    // переделанная функция из task 13.10.19
    fun numberOfDays(month: String, year: Int): Int =
        when {
            (month == "января") -> 31
            (month == "февраля") && (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)) -> 29
            (month == "февраля") -> 28
            (month == "марта") -> 31
            (month == "апреля") -> 30
            (month == "мая") -> 31
            (month == "июня") -> 30
            (month == "июля") -> 31
            (month == "августа") -> 31
            (month == "сентября") -> 30
            (month == "октября") -> 31
            (month == "ноября") -> 30
            (month == "декабря") -> 31
            else -> throw DataFormatException("Month isn't in range from 1 to 12")
        }

    // чтобы убрать 2 лишние проверки из regex,
    // которые увеличивают количество проверок в 2 (!) раза
    val text = " $s "

    // диапазон дней: 1 - 31
    val checkingDay = "(([1-9])|([1-2][0-9])|(3[0-1]))"

    val months = listOf(
        "декабря", "января", "февраля",
        "марта", "апреля", "мая",
        "июня", "июля", "августа",
        "сентября", "октября", "ноября"
    )
    val checkingMonth = "(${months.joinToString("|")})"

    // диапазон лет: 1000 - 2021
    val checkingYear = "((1[0-9]{3})|(20[0-1][0-9])|(202[0-1]))"

    // """ - не нужно экранирование
    val regexDates = """\s${checkingDay}\s${checkingMonth}\s${checkingYear}\s""".toRegex()

    // список дат, распарсенных на число, месяц и год
    val listOfDates1 = regexDates.findAll(text).map { it.value.drop(1).dropLast(1).split(" ") }.toList()

    // оставляет только корректные даты
    // например, не может быть 31 сентября (в этом месяце только 30 дней)
    val listOfDates2 = listOfDates1.filter { it[0].toInt() <= numberOfDays(it[1], it[2].toInt())}

    // поскольку дальше ничего с этими датами делать не нужно
    // возвращаем в удобном виде List<String>, а не List<List<String>>
    return listOfDates2.map { it.joinToString(" ") }
}
