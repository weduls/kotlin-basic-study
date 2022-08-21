package upscale

// 확장하려는 대상 다음 메소드를 정의해서 확장함수를 정의
fun String.first(): Char {
    // this는 확장 대상의 객체의 참조를 의미한다.
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

class MyExample {
    fun printMessage() = println("wedul")
}

// 기존 클래스의 존재하는 메소드를 확장했을 경우 기존 메소드 내부에 있는 것이 우선시 됨
fun MyExample.printMessage() = println("extension test")
fun MyExample?.printNullOrNotNull() {
    if (this == null) println("this object is null")
    else println("this object is not null")
}

fun main() {
    println("ABCD".first())
    println("ABCD".addFirst('s'))

    val myExample = MyExample();
    // wedul이 출력됨
    myExample.printMessage()

    // null able (null관련 안전성 여부를 확장함수에서 처리를 해줬기 때문에 사용시에 null 체크 없이 사용 가능)
    var nullableTest: MyExample? = null
    nullableTest.printNullOrNotNull()
    nullableTest = MyExample()
    nullableTest.printNullOrNotNull()
}

