package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 类的解构
 * 1.类的参数可以被解构
 * 2.解构语法
 *      operator fun component1() = name//第一个参数 name 对应 component1()
 *      operator fun component2() = age//第二个参数
 * 3.必须从 component1 开始,必须与参数的顺序对应
 *
 */
class TestComponent(var name: String, var age: Int) {
    var gender: Int? = null
    operator fun component1() = name
    operator fun component2() = age
    operator fun component3() = gender

    constructor(name: String, age: Int, gender: Int) : this(name, age) {
        this.gender = gender
    }
}

data class TestComponentDataClass(var name: String, var age: Int) {
    var gender: Int? = null

    /**
     * data class 中不需要手动解构,自动生成的,手动添加会报错
     */
//    operator fun component1() = name
//    operator fun component2() = age
//    operator fun component3() = gender

    constructor(name: String, age: Int, gender: Int) : this(name, age) {
        this.gender = gender
    }
}

fun main() {
    var (name, age, gender) = TestComponent("whl", 33)
    println("name: $name , age: $age , gender: $gender")
    val (name1, age1) = TestComponentDataClass("haha", 33, 1)
    println("name: $name1 , age: $age1 , gender: $gender")
    val (_, age2_) = TestComponentDataClass("www", 33, 1)
    println("age: $age1")

}