package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 泛型
 */
class Generic<T>(val p: T) {
    fun show() = println(p)
}

data class Type(var name: String)

fun main() {
    Generic(Type("Int")).show()
    var a  = "whl"
    a.let {  }
}