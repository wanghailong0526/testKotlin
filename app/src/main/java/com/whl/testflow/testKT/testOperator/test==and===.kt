package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * == 值的比较 java 用 equals
 * === 对象的比较 java 用 ==
 */
fun main() {
    val str1 = "Whl"
    val str2 = "Whl"
    val str4 = String("Whl".toCharArray())
    println(str1 == str2)//打印 true
    println(str1 === str2)//打印 true 因为在常量池里里使用了同一个对象

    val str3 = "whl".capitalize()
    println(str3 === str1)//打印 false
    println(str3 == str1)//打印 true 值是相等的，但是不是一个对象

    println(str4 === str1)//打印 false

}