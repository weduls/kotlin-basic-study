package upscale

/**
 * var로 할당하기
 */
class LazyStudyOfVar {

    // var로 뒤에 데이터를 넣을 수 있지만 var타입은 언제나 값이 변할 수 있는 위험성이 있기 때문에 사용 금지
    var greeting: String? = null
    fun sayHello() = println(greeting)
}

/**
 * by lazy (불변 객체에 대한 초기화)
 */
class LazyStudyOfLazyKeywordWithNone {

    // val대신 var를 사용하면 안된다.
    val greeting: String by lazy(LazyThreadSafetyMode.NONE) {
        // by lazy로 초기화된 내용은 한번만 호출되어 할당되기 때문에 유용. 밑에 초기화중은 한번만 호출됨
        println("초기화 중")
        getHello()
    }
    fun sayHello() = println(greeting)
}

class LazyStudyOfLazyKeywordWithPublication {

    // val대신 var를 사용하면 안된다.
    val greeting: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        // by lazy로 초기화된 내용은 한번만 호출되어 할당되기 때문에 유용. 밑에 초기화중은 한번만 호출됨
        println("초기화 중")
        getHello()
    }
    fun sayHello() = println(greeting)
}

class LazyStudyOfLazyKeywordWithSynchronized {

    // val대신 var를 사용하면 안된다.
    val greeting: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        // by lazy로 초기화된 내용은 한번만 호출되어 할당되기 때문에 유용. 밑에 초기화중은 한번만 호출됨
        println("초기화 중")
        getHello()
    }
    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

/**
 * late init
 */
class LateInit {
    // nullable이 아닌데도 컴파일 오류가 발생하지 않음
    // 초기화 되지 않은 상태에서 접근해서 사용하면 lateinit property text has not been initialized 에러가 발생한다.
    // di용에서도 사용 가능
    lateinit var text: String

    fun printText() {
        // ::의 의미 https://medium.com/harrythegreat/%EC%BD%94%ED%8B%80%EB%A6%B0%EC%9D%98-%EB%8D%94%EB%B8%94%EC%BD%9C%EB%A1%A0-%EC%B0%B8%EC%A1%B0-73ff25484586
        if (this::text.isInitialized) {
            println("초기화합니다!")
        }

        text = "안녕하세요 lateInit 입니다."
        println(text)
    }
}

fun main() {
    // var로 선언된 변수를 뒤늦게 할당하여 사용
    val lazyStudy: LazyStudyOfVar = LazyStudyOfVar()
    lazyStudy.greeting = getHello()
    lazyStudy.sayHello()

    // by lazy none전략일 경우 여러번 초기화
    val lazyStudyOfLazyKeywordWithNone = LazyStudyOfLazyKeywordWithNone()
    for (i in 1..5) {
        Thread {
//            lazyStudyOfLazyKeywordWithNone.sayHello()
        }.start()
    }

    // by lazy publication 전략인 경우
    val lazyStudyOfLazyKeywordWithPublication = LazyStudyOfLazyKeywordWithPublication()
    for (i in 1..5) {
        Thread {
//            lazyStudyOfLazyKeywordWithPublication.sayHello()
        }.start()
    }

    // by lazy synchronized 전략인 경우
    val lazyStudyOfLazyKeywordWithSynchronized = LazyStudyOfLazyKeywordWithSynchronized()
    for (i in 1..5) {
        Thread {
            lazyStudyOfLazyKeywordWithSynchronized.sayHello()
        }.start()
    }

    // late init
    val lateInit = LateInit()
    lateInit.printText()
}