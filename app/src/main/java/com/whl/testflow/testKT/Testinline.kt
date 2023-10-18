package com.whl.testflow.testKT


/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: inlin 关键字
 * 作用是 函数类型参数展开 我理解就是 lambda 展开
 *
 * main 方法编译后结果如下
 * fun main(){
 *  println("hello")
 *  println("hello again")
 *
 * }
 *
 */

fun main() {
    hello {
        println("hello again")
    }
}

inline fun hello(block: () -> Unit) {
    println("hello")
    block()
}
