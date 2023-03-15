package com.whl.testflow.testKT

import java.io.File

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 数组
 * ByteArray byteArrayOf()
 * ShortArray shortArrayOf
 * CharArray charArrayOf()
 * IntArray intArrayOf()
 * LongArray longArrayOf()
 * FlotArray flotArrayOf()
 * DoubleArray doubleArrayOf()
 * BooleanArray booleanArrayOf()
 * 对象数组
 * Array<对象类型> arrayOf()
 * 1.取元素
 *  1.var shorts= shortArrayOf()
 *   shorts[0]
 *
 *  2.shorts.elementAt(0)
 *
 *  3.shorts.elementAtOrElse(0,{-1}) 如果越界返回 -1
 *  4.shorts.elementAtOrNull(3) 如果越界返回 null
 */
fun main() {
    var bytes = byteArrayOf(1,2,3)
    var shorts= shortArrayOf(2,3,3)
    var booleans = booleanArrayOf(false,false,false,false)
    println(shorts.elementAtOrElse(3, { -1 }))
    println(shorts.elementAtOrNull(3))


    var arrys = arrayOf(File("111.txt"),File("222.txt"))

}