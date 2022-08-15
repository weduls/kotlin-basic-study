// constuct 명칭을 추가해서 생성자를 만들수도 있다.
class Lesson6 constructor(val name: String) {
}

// construct를 생략할 수 도 있다.
class Lesson6NoSecond(val name: String) {
}

// 후행 쉼표(Trailing commas)를 사용할 수 있어서 나중에 변경된 부분만 트레킹하기에 좋다.
class Coffee(val name: String = "", val price: Int,) {
}

// 생성자 파라미터를 val, var 타입 모두 사용가능
// var로 생성된 키워드는 getter, setter를 자동으로 만들어준다.
// val타입의 경우 getter만 존재하고 setter는 존재하지 않는다.
class CoffeeWithVar(var name: String = "", var price: Int = 0,) {
}

// 본문 내용이 없는 class를 만들 수 있다.
class Lesseon6Tow

// custom getter, setter(val 타입에서만)를 만들 수 있다.
class CustomGetter(var name: String = "", var price: Int = 0) {
    val brand: String
        get() = "스타벅스"

    var quantity: Int = 0
        set(value) {
            if (value > 0) {
                // field는 getter, setter 내에서 필드에 접근하기 위해서 사용하는 식별자
                // backing field에 접근한다고 한다고 한다. 그렇게 접근하지 않고 만약 quantity에 접근해서 사용하게 되면 재귀에 빠지게 된다.
                field = value
            }
        }

}

fun main() {
    val coffee: Coffee = Coffee("아이스아메리카노", 123)
    println(coffee.name)
    println(coffee.price)

    val coffeeWithVar: CoffeeWithVar = CoffeeWithVar();
    coffeeWithVar.name = "카페라떼"
    coffeeWithVar.price = 305
    println(coffeeWithVar.name)
    println(coffeeWithVar.price)

    // 커스텀 게터를 만들 수 있다.
    val customGetter = CustomGetter();
    println(customGetter.brand)

    // 커스텀 세터를 만들 수 있다.
    customGetter.quantity = -1
    println(customGetter.quantity)
    customGetter.quantity = 1
    println(customGetter.quantity)
}