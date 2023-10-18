package com.whl.testflow.testKT


/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: noinline 不内联
 * 若返回值为 lambda 那么不能用 inline 修饰
 */
fun main() {
    val function = {
        println("hello again")
    }
    function.invoke()
    hello2(function)
}

/**
 * 下面报错 要想返回 lambda 必须使用 noinline 声明
 */
//inline fun hello2(block:()->Unit): () -> Unit{
//    println("hello")
//    return block
//}

inline fun hello2(noinline block: () -> Unit): () -> Unit {
    println("hello")
    return block
}