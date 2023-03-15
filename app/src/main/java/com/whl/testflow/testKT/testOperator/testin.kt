package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * in 0..99 表示 0<=x<=99 这个区间
 * !in 0..99 表示 x 不在这个区间
 *
 */
//编译时常量只能是基本数据类型
//编译时常量只能写在方法外面
const val a = "string"

fun main() {
    println(test(80))

}

/**
 * 如果不指定返回值，那么返回值就是 Unit
 * 如果指定了返回值，方法体最后一行必须是 return
 */
fun test(n: Int): Any {

    var s = when (n) {
        in 0..10 -> "0-10"
        in 11..20 -> "11-20"
//        !in 21..30 -> "不在21-30"
        1 -> true
        else -> {
            println("")
        }
    }
    return s
}