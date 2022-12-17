package test

class TreeNode<T> (val data: T) {
    private val _children = arrayListOf<TreeNode<T>>()

    // 클래스 프로퍼티의 경우 오직 제공되는것만 사용가능 (타입 파라미터가 불가능)
//    var <T> parent:TreeNode<T>? = null
    var parent:TreeNode<T>? = null
    val children: List<TreeNode<T>> get() = _children

    fun addChild(data: T) = TreeNode(data).also {
        _children += it
        it.parent = this
    }

    override fun toString(): String {
        return _children.joinToString(prefix = "$data {", postfix = "}")
    }

}

fun <T> TreeNode<T>.addChildren(vararg data: T) {
    data.forEach { addChild(it) }
}

fun <T> TreeNode<T>.walkDepthFirst(action: (T) -> Unit) {
    children.forEach{ it.walkDepthFirst(action)}
    action(data)
}

fun <T: Number> TreeNode<T>.average(): Double {
    var count = 0
    var sum = 0.0
    walkDepthFirst {
        count++
        sum += it.toDouble()
    }
    return sum/count
}

val <T> TreeNode<T>.depth: Int
    get() = (children.asSequence().map { it.depth }.maxOrNull() ?: 0) + 1

// 실패하는 이유는 함수의 반환값이 제네릭의 반환값으로 사용되어야 한다.
//val minDepth = TreeNode("").depth<String>
fun main() {
    val average = TreeNode(1).apply {
        addChild(1).addChild(2)
    }.average()
    println(average)

    //  Double defined in test in file TreeNode.kt number만 가능함 (컴파일 에러남)
//    val averageString = TreeNode("1").apply {
//        addChild("3").addChild("2")
//    }.average()
//    println(average)
}
