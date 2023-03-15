package com.whl

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 高阶函数
 */
const val a = 5;
var b = 'c'
fun main() {
    show(1) {
        println("输入值为 $it")
        it.toString()
    }

    //使用泛型对所有类型的扩展
    5.test() {
        println("$this")
        true
    }

    a.test() {
        println("$this")
        true
    }

    'c'.test() {
        println("$this")
        false
    }

    a.cc {
        println("$it")

    }
}

//lambda: (Int) -> String 是lambda,最终show函数返回值为 lambda 的返回值 String
fun show(n: Int, lambda: (Int) -> String) = lambda.invoke(n)

//使用泛型对所有类型的扩展
fun <T> T.test(m: T.() -> Boolean) = m()//在 lambda 实现体里实现使用 this
fun <T> T.cc(m: (T) -> Unit)=m(this)//在 lambda 实现体里实现使用 it

