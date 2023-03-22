package com.whl.testflow.testKT.generic

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * reified
 * 1.作用：可以获取使用泛型类型的 class
 * 2.只能用在 inline 修饰的方法中
 */
inline fun <reified T> show(msg: Any?) {
    if (msg is T) {
        println(msg)
    }
}

fun <T> show2(msg: Any?) {
//    if (msg is T) {//此行报错 不知道泛型 T 是什么类型
//        println(msg)
//    }
}

fun main() {
    show<Int>("aaa")
    show<String>("bbbb")
}