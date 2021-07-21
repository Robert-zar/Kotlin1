/*Спросить у пользователя, какой язык
у него любимый, если это Kotlin или Prolog, ответь пользователю, что он
— подлиза, для других языков придумать комментарий, воспользоваться
для решения задачи условным оператором и операторм when.*/

fun main(args: Array<String>) {
    print("Введите имя пользователя:")
    val name: String?= readLine()
    print("$name, какой язык программирования у тебя любимый?: ")
    val language: String?=readLine()
    val languageName: String
    languageName=when(language){
        "Kotlin", "Prolog" ->"Подлиза"
        "C++" -> "Немного сложный"
        "Pascal" ->"Дело твоё"
        "JavaScript" -> "Ну молодец"
        else -> "Какой-то другой"
    }
    println(languageName)
}

