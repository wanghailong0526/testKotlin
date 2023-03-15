package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * KT 中的类
 * 1.field 关键字 代表这个成员的字段
 * 2.类中的成员变量不加权限修饰符，默认为 private
 *      var 默认生成 set get 方法，
 *      val 只生成 get 方法, 没有 set 方法
 * 3.类中的方法不加权限修饰符，默认为 public
 * 4.计算属性
 *   Test类中的 n2 成员 field 被 get 方法覆盖了，在 get 方法中没有用到 n2 的属性 field
 * 5.防范竞态条件
 *   如果一个成员可能会为 null,返回的这个成员的时候我们要做好非空判断或添加备用方案
 *       var info: String? = null
 *       fun show(info: String): String {
 *           return info?.let {
 *               if (it.isBlank()) {
 *                   "null"
 *              } else {
 *                    it
 *               }
 *             } ?: "null"
 *       }
 */
class Test {
    var value = "kwg"
        //下面这两行代码默认的,不写也会默认生成
        get() = field
        set(value) {
            field = value
        }

    val n: Int = 0

    /**
     * 计算属性
     */
    val n2: Int
        get() = (1..1000).shuffled().first()//返回 1-1000 随机值给 get 方法使用

    /**
     * 防范竞态条件
     */
    var info: String? = null
    fun show(info: String?): String {
        return info?.let {//let返回最后一行的结果
            if (it.isBlank()) {
                "let 里是 null"
            } else {
                it
            }
        } ?: "最后是null"
    }
}

fun main() {
    var test = Test()
    test.value = "whl"//背后隐匿调用 set() 方法
    println(test.value)//背后隐匿调用 get() 方法

//    test.n=5 //报错 test类中的 n 是 val 常量，没有 set 方法，不能重新赋值

    println(test.n2)
    println(test.n2)//多次调用会返回不同的值

    val info: String? = null
    println(test.show(info))


}