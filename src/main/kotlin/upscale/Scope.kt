package upscale

fun main() {

    val str: String? = null
    // let은 null이 아닌 경우에만 동작
    str?.let {
        println(it)
    }

    val str2: String? = "wedul"
    // null이 아니기 때문에 반환하게 됨
    // let의 반환값은 기본적으로 함수의 결과를 반환한다.
    val result: Int? = str2?.let {
        println(it)

        // let안에 let을 넣고 스코프 함수가 너무 많이지면 복잡해진다.
        val innerlet: String? = null
        innerlet?.let {
            println("innerlet")
        }
        1234
    }
    println(1234)

    // 스코프를 사용하지 않을 시
    val databaseClient = DatabaseClient()
    databaseClient.url = "localhost:8080"
    databaseClient.username = "wedul"
    databaseClient.password = "password"
    println(databaseClient.connect())

    // 스코프를 사용할 시 훨씬 간결 (with run)
    val connectedWituRun = DatabaseClient().run {
        this.url = "localhost:8080"
        this.username = "wedul"
        this.password = "password"
        this.connect()
    }
    println(connectedWituRun)

    // 스코프를 사용할 시 훨씬 간결 (with let)
    val connectedWithLet = DatabaseClient().let {
        it.url = "localhost:8080"
        it.username = "wedul"
        it.password = "password"
        it.connect()
    }
    println(connectedWithLet)

    /**
     * with 활용
     */
    val connectedWithWith = with(DatabaseClient()) {
        url = "localhost:8080"
        username = "wedul"
        password = "password"
        connect()
    }
    println(connectedWithWith)

    /**
     * apply를 활용
     * let, run, with와 다르게 객체 자체를 반환
     */
    val connectedWitApply: DatabaseClient = DatabaseClient().apply {
        url = "localhost:8080"
        username = "wedul"
        password = "password"

    }
    println(connectedWitApply.connect())

    /**
     * also
     */

    // also 사용 전
    val user: User = User(name = "wedul", "wedul00")
    user.validate()

    // also 사용 후 (반환 타입은 컨텍스트 자신)
    val also = User(name = "wedul", "wedul00").also {
        it.validate()
    }
    also.print()

    /**
     * with
     * 확장함수가 아님, 수신객체 내부의 함수를 사용할 수 있다.
     */
    val strWith = "안녕하세요"
    val length = with (strWith) {
        length
    }
    println(length)

    /**
     * it의 문제
     */
    var hello: String? = "hello"
    var hi: String? = "hi"

    // 내부적으로 let문장이 사용될 때 it이 중첩될 수 있기 때문에 별도 키워드를 명시해서 사용가능
    hello?.let { a ->
        println(a.length)
        hi?.let { b ->
            println(b.length)
        }
    }
}

class User(val name: String, val password: String) {
    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("검증성공")
        } else {
            println("검증 실패!")
        }
    }

    fun print() {
        println("$name $password")
    }
}

class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    // db를 접속하고 boolean 결과를 반환
    fun connect(): Boolean {
        println("db접속중")
        Thread.sleep(1000)
        println("접속완료")
        return true
    }
}
