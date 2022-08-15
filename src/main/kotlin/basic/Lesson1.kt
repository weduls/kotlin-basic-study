// top 레벨에 변수 선언 가능
var x = 5;

fun main() {
    x += 1
    println(x)

    val a: Int  = 1;

    // 타입 추론
    val b = 1

    // 지연할당은 타입을 무조건 명시해주어야한다.
    val c: Int
    c = 3

    /**
     * val(밸)와 var(발) 키워드의 차이점
     * val은 한번 사용 후 재 할당이 불가능함
     */

    // final처럼 동작하기 때문에 값을 재할당할 시 compile 에러 발생
    val d: String = "wedul"
//    d = "test"

    // var은 재할당이 가능, 단 최초 타입 이후에 다른 타입으로 변경하려고 할 경우 컴파일 오류가 발생함
    var i = 123
//    i = "fda"

}