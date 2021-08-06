/* import java.io.File
fun main() {
    print("Ввод: ")
    val s = readLine()!!.toString()
    val listOfStrings = File("ExampleOfList.txt").readText().split("\n")
    println("Исходный список строк:\n")
    outputList<String>(listOfStrings, "\n")
    val sortedListOfStrings = sortStringsByNumberOfWords(listOfStrings)
    println("\nОтсортированный список строк по количеству слов:\n")
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
fun sortStringsByNumberOfWords(listOfStrings: List<String>): List<String> {
    // заменяет n-ое количество пробелов на один
    val regexSpaces = "\\s{2,}".toRegex()

    // dropWhile и dropLastWhile для того, чтобы убрать
    // 1 (!) пробел в начале или конце, если они есть
    // (c регуляркой не очень красиво получается)
    val listOfStrings2 = listOfStrings.map { it ->
        regexSpaces.replace(it, " ").dropWhile { it ==  ' '}.dropLastWhile { it == ' ' } }

    // println("\nList без лишних пробелов:\n")
    // outputList<String>(listOfStrings2, "\n")

    val result = listOfStrings.withIndex().sortedBy { it -> listOfStrings2[it.index].split(" ").size }
    return result.map { it -> it.value }
} */