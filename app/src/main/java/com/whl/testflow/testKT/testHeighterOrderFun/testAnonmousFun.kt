package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 匿名函数
 * 匿名函数就是 lambda 的实现体
 */

fun main() {
    //调用方法1
    show("whl", 33, 1) {
        //这个大括号就是匿名函数
        println(it)
    }
    //调用方法2
    show("whl",33,1,::showInvok)

    val name = "whl"
    //? 为安全调用操作符，若 name 为 null 不调用后面的方法
    val r = name?.capitalize()
    println(r)

    name?.let {
        it.isBlank()
    }

    //声明为可空类型
    var str:String?
    str= null
    var str2:String
//    str2 = null//报错，不能为空
}

//若函数没有显示指明返回值，默认返回为 void 类型，KT 中使用 Unit
fun showInvok(str: String): Unit {
    println(str)
}

inline fun show(name: String, age: Int, gender: Int, block: (String) -> Unit) {
    val str = "姓名：$name, 年龄：$age, 性别：$gender"
    block(str)
}
