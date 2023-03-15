package com.whl

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 *
 */
/**
 * 1.Unit 等于 java 的 void
 * 2.？表示可空
 * 3.Any 非空类型的超类,包含 int 等基本数据类型,不包含 null,如果要包含 null ,使用 Any?
 * 4.java 中的 Object 是引用类型的超类，不包含基本数据类型。基本数据类型想要使用引用必须使用包装类，如:Java.lang.Integer
 * 5. :: 操作符 ::aa (aa 是个函数,::aa 意思是将一个函数作为函数引用赋值给一个变量)
 *  fun aa(){}
 *  var a4 = ::aa;
 * 6.使用 lambda 表示函数声明 ()->Unit 其中 ()表示方法的参数，这里是无参，有参数使用逗号隔开, Unit 表示无返回值
 * 7.若方法只有一个参数 在实现处默认使用 it 代替,可以复写修改参数名
 * 8.函数最后一行是返回值 可以没有 return 关键字
 * 9._ 表示拒收，如: 一个方法不接收某个位置的参数 fun( _ , value : Int)
 * 10.==_值的比较 ===_是否是同一个对象   java 中 ==_是否是同一个对象或同一个引用  equals_值的比较
 * 11.给类添加匿名函数 类.()  如: String.() 给 String 添加匿名函数，lambda 内部会持有 String 的 this
 * 12.函数中的 lambda 就是高阶函数，函数中的函数
 * 13.只要是高阶函数，必须用inline修饰(作用是内联)，为什么，因为内部会对lambda做优化
 * 14.crossinline 你的这个lambda不要给我内联 优化
 */
fun main() {
    //使用 lambda 表示函数声明
    var method1: () -> Unit
    var method2: (Int, Int) -> Any
    var method3: (String, Double) -> Int
//    method1()//无法调用，需要初始化

    //使用 lambda 表示函数声明与实现结合
    var method6: () -> Unit =
        { println("我是method6") } //{ println("我是method6") } 匿名函数，将这个匿名函数赋值给 method6 这个变量
    method6()
    method6.invoke()

    var method7 = { println("我是method7") }
    method7()

    var method8: (String) -> Unit = { str: String -> println("method8 传入参数值为${str}") }
    method8("kwg kwg ")
    var method9: (String) -> Unit = { println("method9 传入参数为$it") }
    method9("****")
    var method10 = { value: Any? -> println("method10 传入参数为$value") }
    method10(10)
    method10("3333333")

    var method11: (Int, Int) -> Any? = { n1: Int, n2: Int -> n1.toString() + n2.toString() }
    println(method11(1, 1))

    //先声明
    var method12: (Int) -> String
    //再实现
    method12 = fun(value) = value.toString()
    println(method12(34567))

    //声明+实现结合
    var method13: (Int) -> String = { it.toString() }
    println(method13(444444))

    var method14: (Int) -> Unit = {
        when (it) {//when 表达式
            1 -> println("传递的是1")
            in 1..20 -> println("传递的是1-20之间的值")
            else -> println("啥也不是")
        }
    }
    method14(16)
    method14(1)
    method14(40)

    var method15: (Int, Int) -> Unit = { _, n2 ->
        println("第二个参数的值为$n2")
    }
    method15(2, 5)

    var method17 = { str: Any? ->
        println("method17 你传入了 $str")
        str//最后一行是返回值
    }
    var str = method17("wl")
    println("接收到 " + str)


    var method18: String.() -> Unit = {
        println("你是$this")
    }
    "1111111".method18()

    var method19: Int.(Int) -> String = {
        "$this+$it=${this + it}"
    }
    println(method19(1, 2))
    println(1.method19(2))


    //输出
    fun t1() {
        println(1)
    }//返回值类型为 Unit 除非指定类型

    fun t2() {
        22222
    }//默认 Unit

    //返回值为 String 类型
    fun t3(): String {
        return ""
    }

    fun t4() {
//        return 11111 //报错 因为声明时没有指定类型，此时返回 int 报错
    }

    //run返回 实现{}里面的函数返回类型
    fun t5(): Boolean = run { true }
    t5()
    //函数返回值是函数
    fun t6(): () -> Boolean = { true }
    t6()()//执行函数返回的函数

    fun t7() = { data: Any? ->
        println("你输入的类型${if (data is Int) "是 Int 类型 $data" else "不是 int 类型 $data"}")
    }
    t7()(88)
    t7()('a')

    fun aa() {}// 标准的函数
    var ab = {}//接收匿名函数的变量

    var ac = ::aa//使用 :: 将 aa 变成函数引用


}

