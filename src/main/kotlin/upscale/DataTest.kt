package upscale

// toString, equals, hashCode, copy, component N을 재정의 해줌
data class Person(val name:String, val age: Int)

fun main() {
    val person1 = Person("wedul" ,12)
    val person2 = Person("wedul", 12)

    // equals를 재정의했기 때문에 동등성 비교가 가능
    println(person2 == person1)

    // hashcode를 재정의 함으로써 해시함수에서도 동등성을 보장
    val set = hashSetOf(person1)
    println(set.contains(person2))

    // toString 정의로 값이 노출
    println(person1)

    // copy (불변성 유지를 위해서 상태를 변경하여 사용하지 말고 새로운 객체를 카피해서 사용한다.)
    val copiedPerson = person1.copy(name = "chul", age = 33)
    println(copiedPerson)

    // component N
    println("이름=${copiedPerson.component1()}, ${copiedPerson.component2()}")

    // 구조 분해 할당
    // 내부적으로는 copiedPerson에 있는 값을 componentN 값을 사용해서 반환해주는 것
    val (name, age) = copiedPerson
}