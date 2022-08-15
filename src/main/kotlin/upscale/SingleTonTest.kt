package upscale

import java.time.LocalDateTime

object SingleTonTest {
    val a = 123
    fun printA() = println(a)
}

object DateTimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    var changeTestVar = "123"
    // const 상수
    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }
}

fun main() {
    /**
     * 싱글톤 테스트
     */
    println(SingleTonTest.a)
    SingleTonTest.printA()

    println(DateTimeUtils.now)
    println(DateTimeUtils.DEFAULT_FORMAT)
    println(DateTimeUtils.same(DateTimeUtils.now, DateTimeUtils.now))

    println(DateTimeUtils.changeTestVar)
    DateTimeUtils.changeTestVar = "wedul"
    println(DateTimeUtils.changeTestVar)

    /**
     * 동반객체
     */
    // 동반객체 테스트
    println(MyClass.a)
    println(MyClass.newInstance())

    // 생략해서 사용가능
    println(MyClass.Companion.a)
    println(MyClass.Companion.newInstance())

    // companion object의 이름 지정 가능
    println(MyClassWithNameCompanionObject.WedulCompanion.a)
    println(MyClassWithNameCompanionObject.WedulCompanion.newInstance())
}

class MyClass private constructor() {
    // 동반객체
    companion object {
        val a = 1234
        fun newInstance() = MyClass()
    }
}

class MyClassWithNameCompanionObject private constructor() {
    // 동반객체
    companion object WedulCompanion {
        val a = 1234
        fun newInstance() = MyClassWithNameCompanionObject()
    }
}