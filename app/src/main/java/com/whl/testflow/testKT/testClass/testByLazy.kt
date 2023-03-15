package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * by lazy
 * 1.用到变量时自动加载，不用不加载
 */
class E {
    val info by lazy {
        initInfo()
    }

    fun initInfo(): String {
        return "kwg"
    }

    fun show() {
        println(info)
    }
}

fun main() {
    var e = E()
    e.show()

}