/* import java.io.File
fun main(){
    print("Ввод: ")
    val s = readLine()!!.toString()
    val listOfStrings = File("ExampleOfList.txt").readText().split("\r\n")
    println("Исходный список строк:\n")
    outputList<String>(listOfStrings, "\n")
    val sortedListOfStrings = task7(listOfStrings)
    println("\nОтсортированный список строк по максимальному количеству слов, идущих после чисел:\n")
    outputList<String>(sortedListOfStrings, "\n")
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

fun task7(listOfStrings: List<String>): List<String> {
    fun findMaxQuantity(it: Iterator<String>, currentQ: Int = 0, max: Int = 0): Int {
        return if (it.hasNext()) {
            val value = it.next()
            if ((value as? Int) != null) {
                if (currentQ > max)
                    findMaxQuantity(it, 0, currentQ)
                else
                    findMaxQuantity(it, 0, max)
            }
            else findMaxQuantity(it, currentQ + 1, max)
        }
        else {
            if (currentQ > max)
                currentQ
            else max
        }
    }

    // заменяет n-ое количество пробелов на один
    val regexSpaces = "\\s{2,}".toRegex()

    // dropWhile и dropLastWhile для того, чтобы убрать
    // 1 (!) пробел в начале или конце, если они есть
    // (c регуляркой не очень красиво получается)
    val listOfStrings2 = listOfStrings.map { it ->
        regexSpaces.replace(it, " ").dropWhile { it == ' ' }.dropLastWhile { it == ' ' }.split(" ") }

    val result = listOfStrings.withIndex().sortedBy { it -> findMaxQuantity(listOfStrings2[it.index].iterator()) }
    return result.map { it -> it.value }
}
*/