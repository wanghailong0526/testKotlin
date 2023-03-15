package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * mutableList
 * 1.可变 list 可以添加删除元素
 * 2.将不可变 list 转换成可变 list
 * list.toMutableList()
 * 3.将可变 list 转换成不可变 list
 * mutableList.toList()
 *
 */
fun main() {
    var list = mutableListOf("a", "b", "c")
    list.add("whl")
    list.add(0, "kwg kwg")
    list.removeAt(0)
    println(list)

    //将可变 list 转换成不可变 list
    var list2 = list.toList();
//    list2.add() //报错

    //将不可变list 转换成可变 list
    var list3 = list2.toMutableList()
    list3.add("h")
    list3.removeAt(0)
}