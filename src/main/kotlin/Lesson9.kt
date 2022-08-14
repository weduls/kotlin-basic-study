enum class PaymentStatus(val label: String) {
    UNPAID("미지급") {
        override fun isPayable(): Boolean {
            return true
        }

    },
    PAID("지급완료") {
        override fun isPayable(): Boolean {
            return false
        }

    },
    FAILED("지급실패") {
        override fun isPayable(): Boolean {
            return true
        }

    },
    EFUNDED("환불") {
        override fun isPayable(): Boolean {
            return false
        }
    };

    abstract fun isPayable(): Boolean
}

// interface를 추가해서 사용할 수 있지만 enum내부에 abstract 키워드를 사용해서 가능 (자바와 동일)
interface payable {
    fun isPayable(): Boolean
}

fun main() {
    println(PaymentStatus.PAID.label)
    println(PaymentStatus.PAID.isPayable())
}