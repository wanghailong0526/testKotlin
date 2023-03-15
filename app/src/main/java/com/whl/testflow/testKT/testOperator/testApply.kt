package com.whl.testflow.testKT

import java.io.File

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 *
 */
fun main() {
    1.apply {
        println(this)
    }

    File("/Users/wanghailong/Downloads/kotlin_file_test.txt").apply {
        readLines().iterator().forEach {
            println(it)
        }
    }.apply {
        setWritable(true)
    }.apply {
        setReadable(true)
    }

    10.apply1 {
        println(this)
    }.apply1 {

    }

}

public fun <T> T.apply1(block: T.() -> Unit): T {
    block(this)
    return this
}

// 只要是高阶函数，必须用inline修饰，为什么，因为内部会对lambda做优化
// I.myApply 万能类型.myApply 所有类型都可以调用
// lambda : I.()  对I泛型进行了匿名函数扩展  好处 lambda持有this == I == "Derry"
// : I 为了链式调用
//  lambda() 调用执行
//
private inline fun <I> I.myApply(lambda : I.() -> Unit) : I {
    lambda()
    return this
}

