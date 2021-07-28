// проверить наличие максимального элемента массива на интервале
import java.util.*
fun main(){
    val mas = readMass()
    println("Введите а: ")
    val input = Scanner(System.`in`)
    val a = input.nextInt()
    println("Введите b: ")
    val b = input.nextInt()
    println("Максимум ${checkMax(mas, a,b)}")
}
fun checkMax(mas: IntArray, a: Int, b: Int): String {
    val inMax = SearchNum(mas, maxDigit(mas))
    if (inMax in a..b)
        return "входит в промежуток"
    return "не входит в промежуток"
}

fun SearchNum(mas: IntArray, inVal: Int, j: Int = 0): Int =
    if (j < mas.size) {
        if (mas[j] == inVal)
            j
        else SearchNum(mas, inVal, j + 1)
    } else inVal

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

fun maxDigit(mas: IntArray): Int =
    arrayOp(mas, { max, x: Int -> if (x > max) x else max }, mas[0]) 
