package upscale

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String): Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자 입니다. ${language}를 사용합니다.")
    }
}

data class FrontEndDeveloper(override val name: String): Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자 입니다. ${language}를 사용합니다.")
    }
}

data class IosDeveloper(override val name: String): Developer() {
    override fun code(language: String) {
        println("저는 ios 개발자 입니다. ${language}를 사용합니다.")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) {
        // abstract일 경우 else가 필요
//        when (developer) {
//            is BackendDeveloper -> pool[developer.name] = developer
//            is FrontEndDeveloper -> pool[developer.name] = developer
//            else -> {
//                println("지원하지 않는 개발자 입니다")
//            }
//        }
        // Developer가 sealed 클래스일 경우 else 불필요
        // 왜냐면 sealed클래스로 작성이된 상위 클래스일 경우 무조건 존재해야하기 때문에 else가 불필요
        // 만약 sealed 클래스를 상속한 자식 클래스가 when에 없을 경우 에러 발생
        when (developer) {
            is BackendDeveloper -> pool[developer.name] = developer
            is FrontEndDeveloper -> pool[developer.name] = developer
            is IosDeveloper -> pool[developer.name] = developer
        }
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper: BackendDeveloper = BackendDeveloper("wedul")
    val frontendDeveloper: FrontEndDeveloper = FrontEndDeveloper("chul")
    val iosDeveloper = IosDeveloper("배민")

    DeveloperPool.add(backendDeveloper)
    DeveloperPool.add(frontendDeveloper)
    DeveloperPool.add(iosDeveloper)

    println(DeveloperPool.get("wedul"))
    println(DeveloperPool.get("chul"))
    println(DeveloperPool.get("배민"))
}