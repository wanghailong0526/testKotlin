package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * infix 中缀表达式 1 to 2
 * 1.对第一个参数进行扩展
 * 2.需要在括号里传入第二个参数
 */
public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
private infix fun <T1, T2> T1.to2(v2: T2): Pair<T1, T2> = Pair(this, v2)

fun main() {
    var maps = mapOf(
        1.to(2),//第一种方式
        2 to 3//第二种方式
    )
}

