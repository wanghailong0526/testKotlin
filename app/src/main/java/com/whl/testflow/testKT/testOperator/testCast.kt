package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 类型转换函数
 * toInt()
 * toIntOrNull
 *
 */
fun main() {
    val s: Int = "6".toInt()
    val s2: Int? = "66.6".toIntOrNull()//转换失败返回 null
    println(s2 ?: 0)
}