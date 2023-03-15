package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 *
 */
fun main() {
    "whl".let {
        println(it)
    }
    "whl".run {
        println(this)
    }
    5.mLet {
        println(it)
    }.mLet {
        println(it)
    }

    var c = 7.mLet2 {
        println(it)
        111
    }.mLet2 {
        println(it)
        true
    }
    println(c)

    8.also {
        println(it)
    }
    var a = 9.apply {
        println(this)
        true
    }
    println(a)

}

//函数返回值为 :T 表示可以链式调用
private inline fun <T, R> T.mLet(block: (T) -> R): T {
    block(this)
    return this

}

// 特点：let 与 run 区别只有一点   let"(I)"持有it        run"I.()"持有this
// 1. T.mLet 万能类型.mLet 所有类型都可以调用
// 2. -> O lambda里面最后一行是true，那就是Boolean
// 3.  (T)  让lambda持有it
private inline fun <T, O> T.mLet2(block: (T) -> O) = block(this)