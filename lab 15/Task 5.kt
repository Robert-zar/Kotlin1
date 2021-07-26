 fun main() {
    val list: List<Int> = inputList()

     // println("Минимальный элемент списка: ${min(list)}")
     // println("Максимальный элемент списка: ${max(list)}")
     // println("Сумма элементов списка: ${sum(list)}")
     // println("Произведение элементов списка: ${mult(list)}")
}
fun inputList(): List<Int> {
    print("Входной список:\n")

    return try {
        readLine()!!.split(" ").map { it.toInt() }
    }
    catch(e: NumberFormatException) {
        println()
        inputList()
    }
}

 fun arrayOp(array: Iterator<Int>, f : (Int, Int) -> Int, accum: Int = 0): Int =
    if (array.hasNext())
        arrayOp(array, f, f(array.next(), accum))
    else accum

fun min(array: List<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> if (a < b) a else b}, array.first())

fun max(array: List<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> if (a > b) a else b}, array.first())

fun sum(array: List<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> a + b})

fun mult(array: List<Int>): Int =
    arrayOp(array.iterator(), { a: Int, b: Int -> a * b}, 1)
