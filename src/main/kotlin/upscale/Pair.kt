package upscale

fun plus(tuple: Tuple): Int {
    return tuple.a + tuple.b;
}
data class Tuple(val a: Int, val b: Int)

fun plus(pair: Pair<Int, Int>): Int {
    return pair.first + pair.second
}

fun main() {
    // tuple객체 생성해서 사용
    val plus = plus(Tuple(1, 3))
    println(plus)

    // pair 사용, pair 코드는 값을 직접 수정이 불가
    // pair는 data class로 copy, componentN등을 지원
    val pair = Pair(10, 20)
    println(plus(pair))

    // pair 복사
    val copyPair = pair.copy(first = 33)
    println(plus(copyPair))

    // component N
    val copyPairComponent2 = copyPair.component2();
    println(copyPairComponent2)

    // pair toList
    val list = copyPair.toList()
    println(list)

    // tuple 이외에 triple도 선언 가능
    val triple = Triple(10, 20, "123")
    println(triple)

    // 구조분해할당 (내부 값을 분해해서 사용)
    val (a: Int, b: Int, c: String) = triple
    println("$a + $b + $c")

    // list등도 구조분해가 가능
    val lists = listOf("123")
    val (cc: String) = lists;

    // data class로 componentN이 제공될 경우 구조분해함수 사용가능
    val tuple = Tuple(1, 2)
    val(t1, t2) = tuple

    // map
    // to는 내부를 확인해보면 pair로 구성되어 있다.
    val map = mapOf<String, String>("정철" to "배고파")
    for ((key, value) in map) {
        println("$key $value")
    }
}