package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * split 分隔
 */
fun main() {
    val str = "a,b,c,d,e"
    val list = str.split(",")
    //解构
    val (a, b, c, d, e) = list
    println("$a,$b,$c,$d,$e")
    println(list)
}