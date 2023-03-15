package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 异常处理
 */
fun main() {
    try {
        val info: String? = null
        checkException(info)
        println(info)
    } catch (e: Exception) {
        println(e)
    }
}

fun checkException(info: String?) {
    info ?: throw CustomException()
}

class CustomException : java.lang.IllegalArgumentException("出问题了！")