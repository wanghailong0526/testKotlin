package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * mutableSset
 * 1.可变set
 * 2.使用
 * var s= mutableSetOf(1,2,3)
 * 3.添加，删除元素
 * s.add(0)
 * s+=1
 * s.remove(0)
 *
 */
fun main() {
    var s = mutableSetOf(1,2,3,4)
    s.add(5)
    println(s)
    s+=6
    println(s)
    s.remove(0)
    println(s)
    s-=1
    println(s)
}