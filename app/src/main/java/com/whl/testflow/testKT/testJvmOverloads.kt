package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * JvmOverloads
 * 1.在 KT 方法中使用此注解，为 Java 端生成重载方法
 *     KT 方法中有默认参数时，KT 中调用可以不给默认参数传递值，但是 java 端调用时不支持这样做，需要在 kt 方法上添加此注解
 */
fun show(msg: String, code: Int = 0) {
    println("$msg $code")
}

@JvmOverloads
fun showInfo(msg: String, code: Int = 0) {
    println("$msg $code")
}

fun main() {
    show("whl")
}