 fun main() {
 val array: Array<Int> = inputArray()

 //   println("Минимальный элемент массива: ${min(array)}")
 //   println("Максимальный элемент массива: ${max(array)}")
 //   println("Сумма элементов массива: ${sum(array)}")
 //   println("Произведение элементов массива: ${mult(array)}")
}
fun inputArray(): Array<Int> {
    print("Входной массив(через пробел):")

    return try {
        readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    }
    catch(e: NumberFormatException) {
        println()
        inputArray()
    }
}

 fun arrayOp(array: Iterator<Int>, f : (Int, Int) -> Int, accum: Int = 0): Int =
    if (array.hasNext())
        arrayOp(array, f, f(array.next(), accum))
    else accum

fun min(array: Array<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> if (a < b) a else b}, array.first())

fun max(array: Array<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> if (a > b) a else b}, array.first())

fun sum(array: Array<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> a + b})

fun mult(array: Array<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> a * b}, 1)