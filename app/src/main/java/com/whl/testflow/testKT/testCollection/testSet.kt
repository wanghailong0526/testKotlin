package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * set 元素不重复
 * 1.生成
 * var s = setOf("a","b","c")
 * 2.获取元素
 * s.elementAt(0) 表示获取第0个元素
 * 3.越界处理
 * s.elementAtOrElse(0,{"越界了"}),如果越界了,返回 越界了
 * s.elementAtOrNull(3) 如果越界了返回 null
 */
fun main() {
    var s = setOf(1, 3, 2)

    println(s.elementAt(0))
    println(s.elementAtOrElse(3, { "越界了" }))
    println(s.elementAtOrNull(3))
    println(s.elementAtOrNull(3) ?: "越界了")
    for (i in s) {
        println(i)
    }
}