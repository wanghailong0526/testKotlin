package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * list 集合去重
 */
fun main() {
    var list = listOf(1, 1, 1, 2, 3)
    println(list)
    //distinct 实现方式 先转换成 mutableSet 再转换成 list
    var list2 = list.distinct()
    println(list2)

    var list3 = list.toMutableSet().toList()
    println(list3)
}