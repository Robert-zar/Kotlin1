 import java.util.*
fun main(){
    val input = Scanner(System.`in`)
    val mas = readMass()
    println("Изменённый массив:")
    printMass(varMinMax(mas))
}

fun SearchNum(mas: IntArray, accum: Int, j: Int = 0): Int =
    if (j < mas.size) {
        if (mas[j] == accum)
            j
        else SearchNum(mas, accum, j + 1)
    } else accum

fun varMinMax(mas: IntArray): IntArray {
    val inMin = SearchNum(mas, minDigit(mas))
    val inMax = SearchNum(mas, maxDigit(mas))
    var a = 0
    a = mas[inMax]
    mas[inMax] = mas[inMin]
    mas[inMin] = a
    return mas
}

 fun arrayOp(mas: IntArray, f: (Int, Int) -> Int, accum: Int, i: Int = 0): Int =
    if (i < mas.size) {
        val a = f(accum, mas[i])
        arrayOp(mas, f, a, i + 1)
    } else accum

fun maxDigit(mas: IntArray): Int =
    arrayOp(mas, { max, x: Int -> if (x > max) x else max }, mas[0])

fun minDigit(mas: IntArray): Int =
    arrayOp(mas, { min, x: Int -> if (x < min) x else min }, mas[0])

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

fun printMass(mas: IntArray, i: Int = 0): String =
    if (i != mas.size) {
        println(mas[i])
        printMass(mas, i + 1)
    } else "\n"
