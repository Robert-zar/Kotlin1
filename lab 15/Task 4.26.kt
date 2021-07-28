// найти количество элементов между первым и последним минимальным
import java.util.*
fun main(){
    val mas = readMass()
    val min1 = arrayOp(mas, { min, x: Int -> if (x < min) x else min }, 10000)
    val min2 = arrayOp(mas, { min, x: Int -> if (x < min && x != min1) x else min }, 10000)
    val inMin1 = SearchNum(mas, min1)
    val inMin2 = SearchNum(mas, min2)
    println(min1)
    println(min2)
    if (inMin1>inMin2) println("Количество элементов между первым и последним минимальным:${inMin1-inMin2-1}")
    else println("Количество элементов между первым и последним минимальным:${inMin2-inMin1-1}")
}

fun arrayOp(mas: IntArray, f: (Int, Int) -> Int, accum: Int, i: Int = 0): Int =
    if (i < mas.size) {
        val a = f(accum, mas[i])
        arrayOp(mas, f, a, i + 1)
    } else accum

fun SearchNum(mas: IntArray, accum: Int, j: Int = 0): Int =
    if (j < mas.size) {
        if (mas[j] == accum)
            j
        else SearchNum(mas, accum, j + 1)
    } else accum

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
