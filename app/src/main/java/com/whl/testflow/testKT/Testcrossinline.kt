package com.whl.testflow.testKT


/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description:
 * 1. 交叉内联，用于修饰内联函数中的函数类型参数，使函数类型参数能被间接调用
 * 2. 被 crossinline 标记的 Lambda 中不能使用 return
 *
 */
// 正确示例
inline fun hello3(crossinline block: () -> Unit) {
    println("Say Hello!")
    runOnUiThread {
        block()
    }
}

fun main() {
    hello3 {
        println("Bye!")
    }
}

fun runOnUiThread(block: () -> Unit){
    block()
}
