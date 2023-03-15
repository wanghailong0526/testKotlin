package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 *
 * list 不可变 list 不能添加，删除元素
 *
 * 1.普通的取值方式是索引
 *     var list2 = listOf("a", "b", "c", "d")
 *     list2[0] 取第0个元素
 * 2.获取元素时防止越界的方法 使用下面的方法不会抛异常
 * list.getOrElse(4, { "越界了" }) 如果越界了，返回 "越界了"
 * list.getOrNull(4) 如果越界了 返回 null
 *
 */
fun main() {
    var list: List<String> = listOf("a", "b", "c", "d")
    var list2 = listOf("a", "b", "c", "d")


    println(list[0])
    println(list[1])
    println(list[2])
    println(list[3])
    println(list.getOrElse(4, { "越界了" }))
    println(list.getOrNull(4))

}