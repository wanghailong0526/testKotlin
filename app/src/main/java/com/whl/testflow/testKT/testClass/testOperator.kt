package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * opeartor 运算符重载
 * 1. 使用 operator fun 类名. 可以提示所有的可重载运算符
 *  operator fun plus(p: TestOperator): Int {
 *       return v1 + p.v1 + v2 + p.v2
 *   }
 */
class TestOperator(var v1: Int, var v2: Int) {

    operator fun plus(p: TestOperator): Int {
        return v1 + p.v1 + v2 + p.v2
    }
}

fun main() {
    println(TestOperator(1, 1) + TestOperator(2, 2))
}