fun main() {

    // null을 주입하려면 문제가 발생한다.
    //    val a: String = null
    //    var b: String = "abcddd"
    //    b = null

    // nullable한 type을 지정하기 위해 ? 사용
    var nullableType: String? = null
    // nullable한 타입에 접근하려고 하면 컴파일 에러 발생
    // nullableType.length
    // 만약 접근하고 싶을 경우 ?를 사용하여 접근 (만약 nullableType이 null일경우 ?뒤의 함수가 호출되지 않는다.)
    val message = nullableType?.length
    println(message)
    // 단 ?로 나온 데이터를 다시 접근해서 사용할수는없다. (컴파일 에러 - null일 가능성이 있기 때문에)
    // val result = message + 1

    // nullable한 타입에 null체크를 통해서는 데이터 접근 및 사용이 가능하다.
    val testVal: Int = if (nullableType != null) nullableType.length + 1 else 0
    println(testVal)

    // 엘비스 연산자 (만약 null일 경우 오른쪽 아닐경우 왼쪽값을 내보낸다.)
    // 엘비스 연산자나 nullable 표현식?은 null가능성이 없는 선언 val에서도 쓸수는 있으나 의미가 없다. (컴파일 오류가 나지는 않음)
    val testValElbisu: Int = nullableType?.length ?: 0
    println(testValElbisu)

    // 단언 연산자 (컴파일러에게 무조건 null이 아니라고 말하는 것) - npe가 발생할 수 있음
    // 일부러 !! 두개를 붙여서 지저분하니 한번더 생각해보라는 의미로써 추가했다고 한다.
    val c: String? = null
    val d = c!!.length

}