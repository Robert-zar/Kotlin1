 /*
import java.io.File

fun main() {
    print("Ввод: ")
    val s = readLine()!!.toString()
    val listOfStrings = File("ExampleOfList.txt").readText().split("\n")
    println("Список источников строк:\n")
     outputList<String>(listOfStrings, "\n")
     println("\nОтсортированный список строк:\n")
     outputList<String>(sortStringsByLength(listOfStrings), "\n")

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
fun sortStringsByLength(listOfStrings: List<String>): List<String> {
    return listOfStrings.sortedBy { it -> it.length }
}
*/