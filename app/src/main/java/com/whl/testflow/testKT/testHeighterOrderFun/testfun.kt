package com.whl.testflow.testKT

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * KT 函数类型与隐式返回
 */
fun main() {
    /**
     * 第一种
     */
    //1.函数声明
    val action: () -> String
    //2.函数实现
    action = {
        "666"//函数最后一行为返回值
    }
    //3.函数调用
    println(action())

    /**
     * 第二种
     */
    //1.声明加实现
    val block: () -> Boolean = {
        false
    }
    //2.调用
    block()

    /**
     * 第三种 lambda 有参数
     */
    //1.声明加实现
    val method: (Int, Int, String) -> String = { n, n2, s3 ->
        "$n $n2 $s3"//函数返回值
    }
    //2.调用
    println(method(1, 2, "s"))

    /**
     * 反引号的使用
     * 1.java的方法可能是KT的关键字，在调用java方法时，将java的方法用两个反此号包起来使其成为普通的方法名
     * 2.用于测试
     */
    TestInvokByKT.`is`()
    var invok = TestInvokByKT()
    invok.`is`(10)

    //调用反引号方法
    `测试`(5)

}

fun `测试`(int: Int) {
    println(int)
}
