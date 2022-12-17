package basic


data class Person(val firstName: String, val familyName: String, val age: Int)

data class Mailbox(val address: String, val persons: MutableList<Person>)

fun main() {
    val box1 = Mailbox("wedul", mutableListOf(Person("jung", "chul", 1), Person("jung", "chul", 2)))
    val box2 = Mailbox("wedul", arrayListOf(Person("jung", "chul", 1), Person("jung", "chul", 2)))

    println(box1 == box2)

    val arrayListOf = arrayListOf("123")
    arrayListOf.add("str");

    val immutableList = arrayOf("123");
    val(firstName) = box1.persons[0];
    println(firstName)
}
