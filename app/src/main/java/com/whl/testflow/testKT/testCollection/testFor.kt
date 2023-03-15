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
    listOf(1, 2, 3).forEach {
        println(it)
    }
    listOf(2,3, 9).mForEach {
        println(it)
    }
    listOf(2,3, 9).mForEach2 {
        println(this)
    }
}

public inline fun <T> Iterable<T>.mForEach(lambda: (T) -> Unit) {
    for (i in this) {
        lambda.invoke(i)
    }
}
private inline fun<T> Iterable<T>.mForEach2(lambda: T.() -> Unit)= run {for (i in this) lambda(i)  }