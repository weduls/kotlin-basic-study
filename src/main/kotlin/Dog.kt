/**
 * 상속
 */

// 기본적으로 상속이 막혀있고 상속이 필요할 때 open이란 키워드를 사용한다.
open class Dog {
    open var age: Int = 0
    open var weight: Int = 0
    open val name: String = "개"
    open fun bark() {
        println("멍멍")
    }
}

// override는 필드에 정의해서 사용할 수도 있고 생성자에 넣어서 사용할 수 있다.
open class BullDog(
    override var age: Int = 299,
    override val name: String = "불독") : Dog() {

    // 오버라이드한 Bulldog의 필드는 기본적으로 open상태이기 때문에 override를 막고 싶다면 final을 붙히면 된다.
    final override var weight: Int = 1299
    override fun bark() {
        println("블독블독")
    }
}

// dog를 상속한 bulldog를 그대로 상속
class ChildBullDog: BullDog() {
    override var name: String = "child블독"

    final override fun bark() {
        // super클래스를 사용해서 상위클래스에 내용을 접근할 수 있다.
        super.bark()
    }
}


/**
 * 추상 클래스
 * 필드까지 abstract 사용가능
 */
abstract class Developer {
    abstract var age: Int
    abstract fun code(language: String): String
}

class BackendDeveloper(override var age: Int) : Developer() {
    override fun code(language: String): String {
        return "run code $language"
    }
}

fun main() {
    val dog = BullDog()
    println(dog.age)
    println(dog.name)
    println(dog.weight)
    dog.bark()

    val childBullDog = ChildBullDog();
    println(childBullDog.name)
    println(childBullDog.name)

    val developer: Developer = BackendDeveloper(123)
    println(developer.age)
    val code = developer.code("code")
    println("$code is code")
}