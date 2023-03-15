package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * _ 解构中使用 _ 表示不接收这个值
 */
fun main() {
    var list = mutableListOf("a", "b", "c")
    var (_, n1, n2) = list
    println("n1 = $n1, n2 = $n2")
}