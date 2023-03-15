package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 函数引用
 * 有 lambda 有地方就可以用函数引用 :: 代替
 */

fun main() {
    //调用方法1
    method(1, ::callback)
    //调用方法2
    method(1,){
        "$it"
    }
    //调用方法3
    val obj = ::callback
    method(1,obj)
    //调用方法4
    method(1, block = {
        "$it"
    })
}

fun callback(n: Int) :String{
    println(n)
    return "成功"
}

inline fun method(n: Int, block: (Int) -> String) {
    block(n)
}