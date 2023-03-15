package com.whl.testflow.testKT

import android.os.Build
import androidx.annotation.RequiresApi

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * map
 * 1.使用方式
 *  1.var m = mapOf("a" to (97), "b" to (98))
 *  2.var m2 = mapOf(Pair("a", 97), Pair("b", 98))
 *
 * 2.取元素
 *  1.m.get(key) 没有 Key 返回 null
 *  2.索引方式 m["b"] 与 get 方式一样
 *  3.m.getOrDefault("c",-1) 若 Key 没有,返回 -1
 *  4.m.getOrElse("c") { -2 } 若 Key 没有,返回 -2
 *  5.m.getValue("c") 若 Key 没有,会抛异常
 */
@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    var m = mapOf("a" to (97), "b" to (98))
    var m2 = mapOf(Pair("a", 97), Pair("b", 98))
    println(m.get("a"))
    println(m.get("c"))
    println(m["b"])
    println(m["c"])

    println(m.getOrDefault("c", -1))
    println(m.getOrElse("c") { -2 })
    println(m.getValue("c"))
}