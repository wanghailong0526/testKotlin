package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * takeIf
 * name.takeIf{true/false}
 * true:返回 name 本身
 * false:返回 null
 */
fun main() {
    var name = "whl"
    println(name.takeIf { true })
    println(name.takeIf { false })
}