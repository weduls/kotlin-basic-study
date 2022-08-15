fun main() {
    /**
     * if
     */
    // if..else 문장
    val job = "Software Developer"
    if (job == "Software Developer") {
        println("개발자")
    } else {
        println("개발자 아님")
    }

    // 코틀린의 if.. else 표현식
    val age: Int = 10
    val str = if (age > 10) "개발자" else "개발자 아님"

    // 코틀린은 if..else문장 자체가 표현식이라 삼항 연산자 자체가 불필요

    /**
     * when
     */
    // when식 자바의 코틀린가 비슷한 문법
    // 사이의 ,를 구분하지 않으며 마지막에 java의 default처럼 else를 해줘야한다.
    // 만약 Enum의 구성내용들이 모두 when에 선언되어있으면 나올 수 있는 모든 경우가 출력된것이기 때문에 else문이 없어도 된다.
    val day = 2
    val result: String = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        5 -> "금요일"
        6 -> "토요일"
        7 -> "일요일"
        else -> "없음"
    }

    // 표현식을 바꿔서 콤마(,)를 사용해서 한줄로 정의할 수 있다.
    // 콤마를 사용하지 않고 한줄에서 표현이 가능하다.
    when (2) {
        0, 1 -> print("0 또는 1")
        else -> println("나머지")
    }

    /**
     * 범위 연산자
     */
    // ..을 사용해서 범위 연산자를 사용할 수 있다. (<= && <= 상태가 된다.)
    for (i in 0..3) {
        println(i)
    }

    // untill을 사용 <= && < 비교가 된다.
    for (i in 0 until 1) {
        println(i)
    }

    // step을 사용해서 특정 값만큼 증가 시킬 수 있다. (2씩 값이 증가)
    for (i in 0 ..6 step 2) {
        println(i)
    }

    // downto을 사용해서 특정 값만큼 증가 시킬 수 있다. (2씩 값이 감수)
    for (i in 6 downTo  2 step 2) {
        println(i)
    }

    // 전달받은 배열을 반복
    val numbers = arrayOf(1, 2, 3)
    for (i in numbers) {
        println(i)
    }

    /**
     * while 문
     */
    var x = 5
    while (x > 0) {
        println(x)
        x--
    }

}