package upscale

import java.io.FileWriter

class UpscaleException {
}

fun getStr(): Nothing = throw Exception("예외값 발생")

fun main() {
    FileWriter("test.txt")
        .use {
            it.write("Hello Kotlin")
        }

    // 예외
    val result = try {
        getStr()
    } catch (e: java.lang.Exception) {
        println(e.message)
        // 반환되는값
        "기본값"
    }

    // 기본값 문구가 출력됨
    println(result)

    // 위 try-catch를 우아하게 처리
    /**
     * 실패시에서는 exception을 수신자 객체에게 전달하며 함수의 마지막에 있는 값을 반환한다.
     */
    val resultRunCatch = runCatching { getStr() }.getOrElse {
        println(it.message)
        "기본값"
    }
    println(result)

    /**
     * 실패 시 null값 반환
     */
    val resultGetOrNull = runCatching { getStr() }.getOrNull();
    println(resultGetOrNull)

    /**
     * 실패하면 exception을 반환하고 성공하면 null 반환
     */
    val resultExceptionOrNull: Throwable? = runCatching { getStr() }.exceptionOrNull()
    resultExceptionOrNull?.let {
        println(it.message)
    }
    println(resultExceptionOrNull)

    /**
     * 성공시 성공한걸 가져오고 실패할경우 default값을 반환함
     */
    val resultOrDefault = runCatching { getStr() }.getOrDefault("wedul")
    println(resultOrDefault)

    /**
     * 성공한 값을 변형
     */
    val resultMap = runCatching { "안녕" }
        .map {
            "${it}하세요"
        }.getOrThrow()
    println(resultMap)

    /**
     * map에서 exception이 발생해도 리커버리가가능
     */
    val resultMapCatching = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외")
        }.getOrDefault("기본 값")
    println(resultMapCatching)

    /**
     * recovor는 성공시에는 아무것도 하지 않고 실패시에 동작
     */
    val resultWithRecover = runCatching { getStr() }
        .recover {
            // 단순 값 반환이 아니라 실패시에 일어나는 행위에 대해 기재가능
            "복구"
        }
        .getOrNull()
    println(resultWithRecover)

    /**
     * recover 도중 예외가 발생했을 때 재처리가 가능
     */
    val resultWithRecoverCatching = runCatching { getStr() }
        .recoverCatching {
            // 단순 값 반환이 아니라 실패시에 일어나는 행위에 대해 기재가능
            throw Exception("ss")
            "복구"
        }
        .getOrDefault("recover catching 복구")
    println(resultWithRecoverCatching)

    /**
     * getOrThrow 성공아니면 예외
     */
    val resultGetOrThrow = runCatching { getStr() }.getOrThrow()
}