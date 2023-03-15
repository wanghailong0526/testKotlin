package com.whl.testflow.testKT

import android.os.Build
import androidx.annotation.RequiresApi

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * mutator
 * 1.可以使用 += 添加元素 -=删除元素
 * removeIf
 * 2.根据条件删除 list 元素
 */
//@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    var list = mutableListOf("a", "a", "b", "c")
    list += "aba"
    list += "bb"
    list -= "a"
    println(list)

    //android N(24) 才有这个方法
    list.removeIf {
        it.contains("a")
    }
    println(list)
    list.filter {
        it.contains("b")
    }.forEach {
        println(it)
    }

    for (i in list) {
        println(i)
    }
    list.forEach {
        println(it)
    }
    list.forEachIndexed { idx, s ->
        println("[$idx] = $s")
    }
}