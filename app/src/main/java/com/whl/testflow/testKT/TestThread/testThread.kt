package com.whl.testflow.testKT

import kotlin.concurrent.thread

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 *
 */
fun main() {
    thread {
        println(1)
    }
    var mTask = mThread(start = false,name = "whl") {
        println("thread test")
        println("线程名 = ${Thread.currentThread().name}")
    }
    //手动开启线程执行
    mTask.start()

    //直接执行
    mThread() {
        println("thread test")
        println("线程名 = ${Thread.currentThread().name}")
    }
}

private fun mThread(name: String? = null, start: Boolean = true, block: () -> Unit): Thread {
    var thread = object : Thread() {
        override fun run() {
            super.run()
            block()
        }
    }
    name?.let { thread.name = name }
    if (start) thread.start()
    return thread
}