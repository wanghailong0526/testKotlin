package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * replace
 */
fun main() {
    var sourcePWD = "ABCDEDGHIJKLMNOPQRSTUVWXYZ"

    val newPWD = sourcePWD.replace(Regex("[AKMON]")) {
        println("原密码为 ：${it.value}")
        when (it.value) {
            "A" -> "9"
            "K" -> "3"
            "M" -> "5"
            "O" -> "1"
            "N" -> "4"
            else -> it.value
        }
    }
    println("加密后的密码为：$newPWD")

    sourcePWD = newPWD.replace(Regex("[93514]")) {
        when (it.value) {
            "9" -> "A"
            "3" -> "K"
            "5" -> "M"
            "1" -> "O"
            "4" -> "N"
            else -> it.value
        }
    }
    println("解密后的密码为 $sourcePWD")
}