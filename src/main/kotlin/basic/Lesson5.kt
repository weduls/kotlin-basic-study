fun main() {
    // java와 달리 checked exception이 강제되지 않는다.
    Thread.sleep(10)

    // 강제로 넣을 수 있음
    try {
        Thread.sleep(10)
    } catch (e: Exception) {} finally {
        println("finally!!!!!!!1")
    }

    // 코를린에서는 try.. catch도 표현식으로 사용 가능 (이 구문에서는 에러가 발생하기 때문에 tryCatch 변수내에는 Unit값이 들어있음
    val tryCatch = try { "1234f".toInt() } catch (e: Exception) { println("sdf") }

    // 강제 Exception 발생도 가능하다 (new를 사용하지 않는다.)
    // Exception을 throw하게 되면 Noting 타입을 반환하게 되는데 이로인해서 아래 코드들은 unreachable 경고를 ide에서 보여준다.
    throw IllegalArgumentException("hungry");
    // unreachable code
    println("ㅇㄴㅇㄹ")
}

