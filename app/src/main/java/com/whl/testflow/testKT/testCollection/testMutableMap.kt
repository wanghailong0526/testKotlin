package com.whl.testflow.testKT

import android.os.Build
import androidx.annotation.RequiresApi

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * mutableMap 可变 map
 * 1.使用
 * var m = mutableMapOf(Pair("a", 97), Pair("b", 98))
 * 2.添加 获取 删除 元素
 *  1.添加操作 1.+= 2.[] 3.put
 *          m.put("c", 99)
 *          m["d"] = 100
 *          m += "e" to (101)
 *
 *  2.获取元素操作
 *          1.m.get(key) 没有 Key 返回 null
 *          2.索引方式 m["b"] 与 get 方式一样
 *          3.m.getOrDefault("c",-1) 若 Key 没有,返回 -1
 *          4.m.getOrElse("c") { -2 } 若 Key 没有,返回 -2
 *          5.m.getValue("c") 若 Key 没有,会抛异常
 *          6.m.getOrPut("f"){102}
 *              如果没有 "f" 这个 key,
 *              将 pair("f",102) 添加到 map 中，再获取值，
 *              如果有,则直接获取 "f" 的值,102 将失去作用
 */
fun main() {
    var m = mutableMapOf(Pair("a", 97), Pair("b", 98))
    //添加元素
    m.put("c", 99)
    m["d"] = 100
    m += "e" to (101)

    //获取元素
    println(m["a"])
    println(m.get("b"))
    m.getOrDefault("a", -1)
    println(m)
    m.getOrElse("a") { -2 }
    println(m)
    m.getOrPut("f") { 102 }
    println(m)

}