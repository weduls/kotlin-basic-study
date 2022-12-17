package upscale

import java.util.LinkedList
import java.util.stream.Collectors

fun main2() {
    /**
     * list
     */
    // immutable (추가된 이후에 다른 코드로 변경 불가)
    val concurencyList = listOf("달러", "유로", "원")

    // mutable list (add 메소드 제공)
    val mutableCurrentList = mutableListOf<String>("달러", "유로", "원")
    mutableCurrentList.add("추가 가능")

    // mutable list apply
    val mutableCurrentListApply = mutableListOf<String>().apply {
        add("달러")
        add("원")
        add("유로")
    }

    // immutable set
    val immutableSet = setOf("치킨", "피자", "탕수육")

    // mutable set
    val mutableSet = mutableSetOf<String>()
    mutableSet.add("피자")

    // mutable set apply
    val mutableSetApply = mutableSetOf<String>().apply {
        add("달러")
        add("원")
        add("유로")
    }

    // immutable map (to라는 키워드는 키와 값을 매핑해주는 것)
    val numberMap = mapOf("one" to 1, "two" to 2)

    // mutable map
    // put이 사용가능하지만 할당 하는 방식으로 변경이 가능하다.
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["치킨"] = 123

    // collection builder 사용이 가능하다. 단, 반환되는 리스트의 형태는 immutable list를 반환한다.
    val numberListWithCollectionBuilder = buildList<String> {
        add("달러")
        add("원")
        add("유로")
    }

    // linked list (리스트에 용도에 맞는 컬렉션을 사용할 수 있다.)
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(3)
        addLast(13)
    }

    // array list (리스트에 용도에 맞는 컬렉션을 사용할 수 있다.)
    val arrayList = ArrayList<Int>().apply {
        add(3)
        addAll(arrayOf(3))
    }

    // iterator 반복 사용
    val iterator = arrayList.iterator()
    while (iterator.hasNext()) {
        println( iterator.next())
    }

    // foreach
    for (data in arrayList) {
        println(data)
    }

    // inline
    arrayList.forEach(::println)

    // map (stream, map)
    // stream을 사용해도 되지만 kotlin 자체 콜렉션에서 편한 인라인 함수를 제공하고 있어서 사용하면 된다.
    // stream에서는 중간연산자 (terminal operation) 이후에 종단 연산자(terminal operator)를 사용해야하는데 코틀린은 그게 없어서 훨씬 편한게 사용가능
    val convertedMap = arrayList.stream().map { data -> "$data" }.collect(Collectors.toList())
    val converted = arrayList.map { data -> "$data" }
    convertedMap.forEach(::println)
    converted.forEach(::println)

    // 단, 콜틀린에서 제공하는 filter등의 함수는 계속해서 새로운 리스트를 만들어내기 때문에 메모리를 잡아먹을 수 있다. 그래서 많은 필터가 들어가거나 많은 체이닝 함수가 들어갈 때는 asSequence를 사용해서 써라
    val filteredListWithSequence = arrayList
        .asSequence()
        .filter { it == 3 }
        .toList()

}




















