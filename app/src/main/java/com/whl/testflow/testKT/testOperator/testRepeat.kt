package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 *
 */

fun main() {
    repeat(10) {
        println(it)
    }

    mRepeat(10) {
        println(it)
    }
    5.mRepeat2 {
        println(it)
    }
}

private inline fun mRepeat(count: Int, action: (Int) -> Unit) {
    for (i in 0 until count) {
        action(i)
    }
}

private inline fun Int.mRepeat2(action: (Int) -> Unit) {
    for (i in 0 until this) action(i)
}