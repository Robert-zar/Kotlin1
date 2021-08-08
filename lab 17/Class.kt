import java.util.*

fun main() {
    // task 1
    val robert = Passport("Заргарян", "Роберт", "Сетракович",
        Date(2001, 3, 5), "Краснодар",
        Date(2021, 3, 29), Date(2046, 3, 5),
        "ГУ МВД РОССИИ", "0317", "179639",
        "Краснодар",)

    // task 2
    robert.printPassport()
}
class Passport(private val surname: String,
                     private val name: String, private val patronymic: String,
                     private val dateOfBirth: Date, private val placeOfBirth: String,
                     private val dateOfIssue: Date, private val expiryDate: Date,
                     private val policeDepartment: String,
                     private val licenseSeries: String, private val licenseNumber: String,
                     private val placeOfIssue: String)
                      {

    fun printPassport() {
        println("Паспорт")
        println("1\t$surname $name $patronymic")
        println("2\t${getDate(dateOfBirth)}, $placeOfBirth")
        println("3\tВыдан:\t${getDate(dateOfIssue)}\tЗамена:\t${getDate(expiryDate)}")
        println("\tКем:\t$policeDepartment")
        println("4\t$licenseSeries $licenseNumber")
        println("5\t$placeOfIssue")
    }

    private fun getDate(date: Date): String {
        val check = {date: Int -> if (date < 10) "0$date" else "$date"}
        return "${check(date.date)}.${check(date.month)}.${date.year}"
    }
}