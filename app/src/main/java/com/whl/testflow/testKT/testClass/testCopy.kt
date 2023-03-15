package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * copy
 * 1.使用
 * var p =p1.copy("name")
 * 2.copy 只负责主构造的参数(还包括toString hashCode equals )，次构造的参数不管
 */
data class TestCopy(var name: String) {
    var age: Int = 0


    init {
        println("父构造")
    }

    constructor(_name: String, _age: Int) : this(_name) {
        println("子构造")
        this.age = _age
    }

    override fun toString(): String {
        return "TestCopy(name='$name', age=$age)"
    }
}

fun main() {
    var p1 = TestCopy("whl", 33)
    println(p1)
    var p = p1.copy()
    println(p)
}

