package com.whl.testflow.testKT

import kotlin.math.roundToInt

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * double 转 int
 * toInt 去掉小数点后面的数 没有四舍五入
 * roundToInt 去掉小数点后面的数 四舍五入
 * 保留小数点后的位数,如下方式保留小数点后3位，第四位有四舍五入
 * var s :String ="%.3f".format(65.345)
 */

fun main() {
    println(65.4326.toInt())
    println(65.4326.roundToInt())

    println(65.5326.toInt())
    println(65.5326.roundToInt())

    //保留小数点后面的位数
    var s = "%.3f".format(64.4564)
    println(s)
    var a = "%.3f".format(64.5565)
    println(a)
}