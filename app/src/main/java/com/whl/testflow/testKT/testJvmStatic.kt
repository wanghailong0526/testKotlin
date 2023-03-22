package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * JvmStatic
 * 1.生成给 Java 调用的静态方法
 */
class Student {

    companion object {

        var name = "whl"
        fun show() {
            println(name)
        }

        @JvmField
        var gender = 0

        @JvmStatic
        fun showInfo() {
            println("性别：$gender")
        }
    }
}

fun main() {
    println(Student.name)
    Student.show()
}