package upscale

class Generic<out T> (val t: T){
}

class GenericSuperTest<T> (){

    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>
    ) {
        to.addAll(from)
    }

}

fun main() {

    // 생성자에 들어가는 데이터가 타입추론을 할 수 있게 해주다보니 타입 파라미터 생략이 가능한다.
    val generics = Generic("wedul")
    val list1: MutableList<String> = mutableListOf()
    val list2 = mutableListOf("wedul")

    // *를 사용해서 어떤 타입이 들어올지 모르는것에 대해서 지정할 수 있다.
    val list3: List<*> = listOf("테스트")
    val list4: List<*> = listOf(123)

    // PECS(Producers-Extends, Consumer-Super)
    // 공변성은 자바 제네릭의 extends 코틀린에서는 out
    // 반공변성은 자바 제네릭의 super 코틀린에선 in
    // 전달한 파라미터를 가지고 무언가를 받는놈이 한다면 공변성(producer), 내가 전달한 거에 무언가를 한다면 conumser(반공변성)

    // 공변성 테스트
    // charSequence가 String보다 상위타입이기 때문에 out을 붙였을 때 할당 가능
    val genericsTest = Generic<String>("wedul")
    val charGenerics: Generic<CharSequence> = genericsTest

    // 반공변성 테스트
    // 넣어야하는 인자는 String이었는데 넣는 인자는 CharSequence이기 때문에 super를 대체할 in을 넣어줘야한다.
    val superTest: GenericSuperTest<String> = GenericSuperTest();
    superTest.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("123", "4556"))


}