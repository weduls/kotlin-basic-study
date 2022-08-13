// 기본적인 함수 선언 스타일
// 함수의 파라미터는 기본적으로 불변
fun sum(a: Int, b: Int): Int {
    return a + b;
}

// 표현식 스타일 (반환타입 생략 가능)
fun sum2 (a: Int, b: Int) = a + b

// 몸통이 있는 함수는 반환타입을 제거하면 컴파일 오류
fun sum3(a: Int, b: Int): Int {
    a + b;

    // 컴파일을 위한 임시 코드
    return 1;
}

// 반환타입이 없는 함수는 Unit을 반환한다.
// Unit은 타입이 없는 것을 의미한다.
fun printSum(a: Int, b: Int): Unit {
    println("$a + $b = ${a + b}")
}

fun greeting(message: String = "안녕하세요") {
    println(message)
}

// 특정 파라미터만 기본값을 부여할 수 있다.
fun log(level: String = "INFO", message: String) {
    println("[$level]$message")
}

fun main() {
    greeting("zzz")
    greeting()

    // 네임드 아규먼트를 사용하면 순서를 맞추지 않아도 사용할 수 있다.
    log(message = "test")
    log(level = "info", message = "배고파")
    log(message = "info", level = "warn")
}