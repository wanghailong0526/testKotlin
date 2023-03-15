package com.whl.testflow.testKT.testClass

import javax.xml.transform.Source

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * is
 * 1.判断某个类型是否是另一个类型的子类
 * as
 * 1.将某个类型转换为另一个类型
 * (i as H).show2()//调用父类的方法
 * 如果已经转换过了可以直接调用父类方法
 * i.show3()
 *
 */
open class H(private var name: String) {
    open fun show() {
        println("父类名字是$name")
    }

    fun show2() {
        println("我是父类2")
    }

    fun show3() {
        println("我是父类3")
    }
}

class I(private var name: String) : H(name) {
    override fun show() {
        println("子类名字是$name")
    }
}

fun main() {
    var i: H = I("whl")
    //如果 i 是 H 的子类
    if (i is H) {
        //将子类转换成父类，调用父类的方法，如果子类重写的父类的方法，调用的还是子类的方法
        (i as H).show2()//调用父类的方法
        (i as H).show()//调用子类的方法
        i.show2()//as 已经转换过了，这里可以直接调用父类方法
        i.show3()//as 转换过了，直接调用父类方法

    }
}