package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 空合并
 * ?:
 * name?:"是null" 如果为null,执行后面的，否则执行name
 */
fun main() {
    val name: String? = "whl"
//    name = null
    println(name ?: "name 为 null")
    //与 let 配合
    val r = name?.let {
        println(it)
    } ?: "name 是null"

}