package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * == 比较的是值 相当于 java 的 equals  ===比较的是对象是否是同一个 相当于 java 的 ==
 * data class
 * 1.数据类，相当于 java 的 bean
 * 2.普通类的 toString()与 data class 的 toString 方法实现不一样
 *      普通类 println(Response("普通类 toString ", 200))//输出 com.whl.testflow.testKT.testClass.Response@7d4793a8
 *      data class println(ResponseBean("data 类 toString", 200)) // ResponseBean(data=data 类 toString, code=200)
 *
 * 3.生成的 class 内部包含，set get 构造 解构 copy  toString equals hashCode
 * 4.data class 必须有主构造并且主构造必须有一个参数
 * 5.data class 主构造参数必须使用 var val 修饰
 * 6.data class 前面不能有修饰符 open abstract inner
 * 7.data class 不能被继续
 * 8.data class 可以继续其它类
 * 9.使用在接口返回数据的时候
 *
 *
 */
open class Response(open var data: String, open var code: Int)
data class ResponseBean(override var data: String, override var code: Int):Response(data,code)

//data class HH{}//报错，data class 必须有主构造并且主构造必须有一个参数
//class JJ(override var data: String, override var code: Int) : ResponseBean(data, code)//报错 data class 不能被继承

fun main() {
    println(Response("普通类 toString ", 200))//输出 com.whl.testflow.testKT.testClass.Response@7d4793a8
    println(Response("普通类 toString ", 200))//输出 com.whl.testflow.testKT.testClass.Response@7d4793a8

    println(ResponseBean("data 类 toString", 200)) // ResponseBean(data=data 类 toString, code=200)
    println(ResponseBean("data 类 toString", 200)) // ResponseBean(data=data 类 toString, code=200)

    //普通类 返回 false
    println(
        Response("普通类 toString ", 200) == Response("普通类 toString ", 200)
    )
    //data class 返回 true
    println(
        ResponseBean("data 类 toString", 200) == ResponseBean("data 类 toString", 200)
    )
}