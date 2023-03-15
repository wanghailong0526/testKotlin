package com.whl.testflow.testKT


/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * forEach
 */
fun main() {
    var sourcePWD = "ABCDEDGHIJKLMNOPQRSTUVWXYZ"
    sourcePWD.forEach {
        println(it)
    }

}


inline fun <T> Iterable<T>.mForEach3(block: (T) -> Unit): Unit {
    for (i in this) {
        block(i)
    }
}

inline fun <T> Iterable<T>.mForEach4(block: (T) -> Unit): Unit = run { for (i in this) block(i) }