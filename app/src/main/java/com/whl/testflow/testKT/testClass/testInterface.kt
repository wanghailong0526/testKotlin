package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * interface 接口
 * 1.interface 本身和内容里的成员都是 public open 的，所以在被继承时不需要 添加 open
 * 2.接口不能有构造函数
 * 3.实现类既要实现接口里的方法也要实现接口里的成员变量
 */
interface IUSB {
    var usbName: String

    fun operator(): String
}

class Mouse(override var usbName: String = "鼠标") : IUSB {
    override fun operator(): String {
        return "点击"
    }

    fun getInfo() = "${usbName}${operator()}"
}

class KeyBoard : IUSB {
    override var usbName: String = "键盘"
    override fun operator(): String {
        return "打字"
    }

    fun getInfo() = "${usbName}${operator()}"
}

fun main() {
    println(Mouse().getInfo())
    println(KeyBoard().getInfo())
}