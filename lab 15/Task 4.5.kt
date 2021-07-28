// является ли элемент по указанному индексу глобальным минимумом
import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val mas = readMass()
    println("Введите индекс: ")
    val index = input.nextInt()
    println("Индекс ${CheckElem(mas, index)}")
}
fun readMass(): IntArray {
    val input = Scanner(System.`in`)
    print("Введите размер массива: ")
    val n = input.nextInt()
    val mas = IntArray(n)
    println("Введите элементы массива: ")
    var i = 0
    while (i < n) {
        mas[i] = input.nextInt()
        i++
    }
    return mas
}
fun arrayOp(mas: IntArray, f: (Int, Int) -> Int, accum: Int, i: Int = 0): Int =
    if (i < mas.size) {
        val a = f(accum, mas[i])
        arrayOp(mas, f, a, i + 1)
    } else accum


fun minDigit(mas: IntArray): Int = arrayOp(mas, { min, x: Int -> if (x < min) x else min }, mas[0])

fun printMass(mas: IntArray, i: Int = 0): String =
    if (i != mas.size) {
        println(mas[i])
        printMass(mas, i + 1)
    } else "\n"

fun CheckElem(mas: IntArray, inVal: Int): String {
    if (minDigit(mas) == mas[inVal])
        return "равен глобальному минимуму"
    return "не равен глобальному минимуму"
}
