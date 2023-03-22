package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * vararg 动态参数
 * 获取类型名称
 * 变量::class.simpleName
 * 变量::class.qualifiedName
 */
class Types<T>(vararg typeList: T) {
    //接收 vararg
    private val typeArray: Array<out T> = typeList

    fun getInfo(idx: Int): T? = /*typeArray[idx]*/ typeArray.getOrNull(idx)
    fun getType(idx: Int) = run {
        getInfo(idx)?.let {
            println(it::class.simpleName)
            println(it::class.qualifiedName)
        } ?: println(null)
    }

    //get 是运算符重载[]
    operator fun get(idx: Int) = typeArray[idx]
    fun getType2(idx: Int) {
        get(idx)?.let {
            println(it::class.simpleName)
            println(it::class.qualifiedName)
        } ?: println(null)
    }
}

fun main() {
    var p = Types(null, 12, "A", 12.1f, 22.22)
    println(p.getInfo(0))
    p.getType(0)

    p.getType2(0)
    p.getType2(1)
    p.getType2(2)
    p.getType2(3)
    p.getType2(4)
}