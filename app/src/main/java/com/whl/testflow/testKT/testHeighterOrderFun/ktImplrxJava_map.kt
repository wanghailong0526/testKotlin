package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * kotlin 实现 rxJava 的 map 操作符
 */

fun main() {
    //第一种
    create {
        34
    }.map {
        true
    }.map {
        23.32
    }.map {
        "c"
    }.map {
        'a'
    }.consumer {
        println(it)
    }

    //第二种
    create2 {
        "w"
    }.map {
        length
    }.map {
        "$this"
    }.map {
        length
    }.consumer2 {
        println(this)
    }

    //第三种
    create3 {
        "whl"
    }.map {
        length
    }.map {
        this + 7
    }.consumer {
        println(this)
    }

    //第四种
    create4 {
        "whl"
    }.map {
        length
    }.map {
        this + 11
    }.consumer {
        println(this)
    }

}

/**
 * 第一种
 */
class Helper<T>(private var item: T) {

    fun <R> map(block: (T) -> R): Helper<R> {

        val newItem: R = block(item)

        // map 将 T 变成 R
        return Helper(newItem)
    }

    fun consumer(block: (T) -> Unit) = block(item)
}

fun <R> create(block: () -> R): Helper<R> {

    var r: R = block()

    return Helper(r)
}

/**
 * 第二种
 */
class Helper2<T>(private var item: T) {

    fun <R> map(block: T.() -> R): Helper2<R> {
        var newItem: R = block(item)
        return Helper2(newItem)
    }

    fun consumer(block: T.() -> Unit) {
        block(item)
    }

    fun consumer2(block: T.() -> Unit) = block(item)
}

fun <R> create2(block: () -> R): Helper2<R> {

    var r: R = block()

    return Helper2(r)
}

/**
 * 第三种
 */
class Helper3<T>(private var item: T) {
    fun <R> map(block: T.() -> R) = Helper3(block(item))
    fun consumer(block: T.() -> Unit) = block(item)
}

fun <R> create3(block: () -> R) = Helper3(block())

/**
 * 第四种
 */
class Helper4<T>(var item: T)

fun <T, R> Helper4<T>.map(block: T.() -> R) = Helper4(block(item))
fun <T> Helper4<T>.consumer(block: T.() -> Unit) = block(item)
fun <R> create4(block: () -> R) = Helper4(block())