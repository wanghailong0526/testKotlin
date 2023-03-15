package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * companion 伴生对象 因为没有 static 关键字，所以 Kotlin 使用伴生对象来表示静态代码块
 * 1.只加载一次
 * 2.通过类名调用 companion 中的方法和成员
 *
 */
class TestCompanion {
    var str: String = "haha"
    fun show(msg: String) {
        println(msg)
    }

    //静态代码块
    companion object {
        var info: String = "我是 companion"
        fun show() {
            println(info)
        }
    }
}

fun main() {
    TestCompanion.show()
    TestCompanion.info = "wwwwwww"
    println(TestCompanion.info)
}