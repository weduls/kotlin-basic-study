
interface Wheel {
    fun roll()
}

interface Cart: Wheel {
    // 코틀린에서는 인터페이스도 프로퍼티를 가질 수 있다. (인터페이스를 구현할 때 이 필드들도 같이 구현해줘야한다.)
    var coin: Int

    // 인터페이스에서도 동일하게 getter필드를 만들 수 있으나 backing field를 사용할 수 없다.
    // 왜냐하면 아직 값이 정해지지 않았기 때문
    val weight: Int
//        get() {
//            field = 123;
//        }

    fun add(product: Product)
    // default 메소드 사용이 가능
    fun rent() {
        if (coin > 0) {
            println("rent posible")
        }
        println("")
    }

    override fun roll() {
        println("카트가 굴러갑니다.")
    }
}

// 자바처럼 복수개의 인터페이스를 추가할 수 있다.
interface Order {
    // 다중 인터페이스에 동일한 함수 오버라이드 되는 함수
    fun add(product: Product) {
        println("${product.name} 의 주문이 완료되었습니다.")
    }

    fun rent() {
        print("주문이 되었기 때문에 추가 렌트를 하실 필요 없습니다.")
    }
}

class MyCart(override var coin: Int, override val weight: Int) : Cart, Order {

    override fun add(product: Product) {
        if (coin <= 0) throw IllegalArgumentException("코인을 넣어주세요")
        println("이름 : ${product.name}, 가격 : ${product.price} 상품이 추가 되었습니다.")

        // 주문하기 (다른 인터페이스의 값을 호출 할 수 있다.)
        super<Order>.add(product)
    }

    // 다중 인터페이스에서 동일한 디폴트 메소드가 있을 경우 구현이 강제가 된다.
    // 강제된 구현내에서 상위 인터페이스를 super<>키워드를 통해서 상위 인터페이스의 디폴트 키워드를 지정해서 사용할 수 있다.
    override fun rent() {
        super<Order>.rent();
        super<Cart>.rent();
    }

}

class Product(val name: String, val price: Int) {
}

fun main() {
    val myCart = MyCart(30, 10)

    myCart.add(Product("치킨", 200))
    myCart.rent()
    myCart.roll()
}