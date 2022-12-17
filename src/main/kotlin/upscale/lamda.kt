package upscale

// String을 반환하는 함수를 의미
val stringReturnFunc: () -> String = { "wedul" }
val printHello: () -> Unit = {println("Hello")}

fun main() {

    val list = mutableListOf(stringReturnFunc, printHello)
    println(list[0]())

    callFunc(stringReturnFunc);

//    mutableListOf(print)

    forEachStr(listOf("a", "b", "c"), printMessage)
    outerFunc()()

    // 후행람다 전달방법,
    forEachStr(listOf("wedul","chul")) {
        println(it)
    }

    // 인자가 2개인 경우 후행 람다 전달방식을 사용하려면 인자를 작성해줘야한다. (it을 사용할 수 없다.).
    forEachStrWithTwoArgs(listOf("wedul","chul")) {a, b ->
        println("$a $b")
    }

    // 레퍼런스 (이전코드)
    val numberList = listOf("1", "2", "3")
    numberList.map {
        it.toInt()
    }.forEach {
        println(it)
    }

    // 레퍼런스 적용
    numberList.map(String::toInt).forEach(::println)
    numberList.map(changeFromStrToInt).forEach(::println)
    numberList.map({a -> a.toInt()}).forEach(::println)
}

val changeFromStrToInt: (String) -> Int = {a -> a.toInt()};

// 이름없는 함수
fun outerFunc(): () -> Unit = { println("wedul") }

// 함수를 인자로 실행
fun callFunc(block: () -> String) {
    block()
}

// 함수를 val로 받아야 1급객체로써 사용이 가능하고 fun으로 생성한 함수의 경우 1급객체로써 사용이 불가능한다.
fun print() = printHello

val printMessage: (String) -> Unit = { message -> println(message)}
val printMessage2: (String) -> Unit = { println(it)}
val plus: (Int, Int) -> Int = { a, b -> a + b}

fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

fun forEachStrWithTwoArgs(collection: Collection<String>, action: (String, String) -> Unit) {
    for (item in collection) {
        action(item, item)
    }
}
val sum2 = {x: Int, y: Int -> x + y}