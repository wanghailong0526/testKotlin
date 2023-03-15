package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * substring 的使用方式
 */
//编译时常量
const val str = "I could be the one!"
fun main(arg: Array<String>) {
    val idx = str.indexOf('c')
    val r = str.substring(0 until idx).replace(" ", "")
    println("$r 长度=${r.length}")
}