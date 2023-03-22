package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * kt 中
 * 1.成员变量默认权限修改符为 public;编译后为 private 提供 set get 方法
 * 2.方法默认为 public
 *
 * JvmField 注释
 * 1.作用:修饰 KT 中的成员
 * 2.编译后去掉 private 变为 public
 * 3.去掉 set get 方法
 * 4.java 端可以直接使用 kt 类中的成员，不然必须通过 get 方法获取
 */
class Person {
    @JvmField
    var name = "whl"
    fun showName() {
        println(name)
    }

}