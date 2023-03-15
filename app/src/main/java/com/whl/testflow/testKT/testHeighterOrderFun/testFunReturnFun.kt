package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 函数返回函数
 */
fun main() {
    val m = show(1)
    println(m(1))

}

// : (n: Int) -> String 表示函数的返回值是一个函数
fun show(int: Int): (n: Int) -> String {
    //返回一个匿名函数
    return { n: Int ->
        "$n"
    }
}