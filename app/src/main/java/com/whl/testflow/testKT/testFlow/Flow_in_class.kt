package com.whl.testflow.testKT.testFlow

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description:
 *
 */

class Flow_in_class {

    /**
     * 在类中使用 main 方法;在静态代码块里使用 @JvmStatic 注解,否则报错
     */
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runBlocking {//提供协程作用域给 flow 使用，在代码块中的代码完之前会阻塞当前线程
                val flow = flowOf(1, 2, 3, 4, 5)
                flow.map {
                    it * it
                }.collect {
                    println(it)
                }
            }
        }
    }
}