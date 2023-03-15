package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * object
 * 1.单例
 *      1.声明类时，将 class 换成 object
 *      2.类名即是类名也是实例
 *
 * 2.对象表达式 相当于 java 的匿名内部类 例如: 类 K
 *      1.使用 object:类名(){
 *
 *            }
 * 3.实现接口 (实现 java 有两种方式；实现 Kotlin 接口只有一种方式)
 *
 */

interface SS {
    fun add(n: Int, n2: Int)
}

object J {
    val s by lazy {
        "whl"
    }

    init {
        println("我是 init 代码块")
    }

    fun show() {
        println(s)
    }
}

open class K {
    open fun show(msg: String) {
        println(msg)
    }

    open fun add(n: Int, n2: Int): Int {
        return n + n2
    }
}

open class OnClickListener {
    open fun onclick() {
        println("点击了")
    }
}

class MyView {
    fun setOnClickListener(clickListener: OnClickListener) {
        clickListener.onclick()
    }
}

fun main() {
    /**
     * object 单例
     */
    J.show()
//    var j  =J()//报错 因为 J 是单例，不能两次构造

    /**
     * object 对象表达式
     */
    var k = object : K() {
        override fun show(msg: String) {
            println(msg)
        }

        override fun add(n: Int, n2: Int): Int {
            return n + n2
        }
    }
    k.show("${k.add(1, 2)}")

    val view = MyView()
    view.setOnClickListener(object : OnClickListener() {
        override fun onclick() {
            println("重写 点击了")
        }
    })

    /**
     * 实现 java 接口的两种方式
     */
    var r = object : Runnable {
        override fun run() {
            println("r 执行 run 方法")
        }
    }
    r.run()

    var r2 = Runnable {
        println("r2 执行 run 方法")
    }
    r2.run()

    /**
     * 实现 Kotlin 的接口
     */
    var ks = object : SS {
        override fun add(n: Int, n2: Int) {
            println("${n + n2}")
        }
    }
    ks.add(1, 2)

}