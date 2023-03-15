package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * lateinit
 * 1.用到时再加载
 * 2.若未初始化，哪里用哪里崩溃
 */

class A {
    lateinit var info: String

    fun initInfo(){
        info = "初始化成功"
    }

    fun show() {
        println(info)
    }
}

fun main() {
    var a = A()
    a.initInfo()
    a.show()
}
