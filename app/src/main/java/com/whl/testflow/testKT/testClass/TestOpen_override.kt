package com.whl.testflow.testKT.testClass

import javax.xml.transform.Source

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * open
 * 1.类默认是 final 修饰 无法被继承 需要在声明时添加 open 关键字就会去掉 final 可被继承
 * 2.方法默认是 final 修饰 无法被重载 需要在声明时添加 open 关键字就会去掉 final 可被重载
 */

open class F(private var name: String) {
    open fun show() {
        println("父类名字是$name")
    }
}

class G(private var name: String) : F(name) {
    override fun show() {
        println("子类名字是$name")
    }
}

fun main() {
    var g: F = G("whl")
    g.show()
    var f = F("wang")
    f.show()
}
