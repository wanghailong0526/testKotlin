package com.whl.testflow.testKT.testOperator

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * takeUnless
 * name.takeUnless{it:true/false}
 * true:返回 null
 * flase:返回 name 本身
 */
class Manager {
    private var info: String? = null
    fun getInfo() = info
    fun setInfo(v: String) {
        this.info = v
    }
}

fun main() {
    val manager = Manager()
    var r = manager.getInfo().takeUnless {
        it.isNullOrBlank()
    } ?: "未初始化"
    println(r)
}