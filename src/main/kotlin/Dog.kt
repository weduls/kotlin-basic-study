// 기본적으로 상속이 막혀있고 상속이 필요할 때 open이란 키워드를 사용한다.
open class Lesson7 {
    open var age: Int = 0
    open fun bark() {
        println("멍멍")
    }
}

open class Lesson7Sub : Lesson7()

fun main() {

}