package com.whl.testflow.testKT

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * 执行顺序
 * 主构造 --> init代码块 --> 次构造
 *
 * 类的主构造函数
 * 1.类名后面的括号就是主构造函数
 * 2.主构造函数里的参数可以有默认值
 * 3.主构造函数，能声明参数，不能直接使用，需要接收后才能用
 * 4.若主构造函数声明参数时使用了var val 可以直接使用，不需要接收后再使用 例如: 类 B
 *
 * 次构造 类 C
 * 1.次构造用来实现构造方法的重载，在次构造中要先调用主构造方法再调用次构造方法
 * 2.在次构造函数中参数不能用var或val声明，因为var或者val声明的参数会成为类的字段
 * 3.
 *
 * init代码块 类 D
 * 1.主构造里声明的临时类型(没有使用 var val 修饰的成员) 只能在 init 代码块里使用
 *     init {
 *       println(_name)
 *       //使用 require 校验参数
 *       require(_name.isNotBlank()) { "name 不能为空" }
 *       require(_age > 0) { "age 必须 >0" }
 *     }
 * 2.require() 用来在 init 代码块里检查构造函数里的参数是否合法
 *  require(_name.isNotBlank()) { "name 不能为空" }
 *  如果条件不满足，抛出异常，异常信息为 "name 不能为空"
 *
 */
class A(
    _name: String = "",
    _info: String = "",
    _age: Int = 1
)//TODO 这个括号就是主构造函数，能声明参数，不能直接使用，需要接收后才能用
{
    val name = _name
    val info = _info
    val age = _age
    fun show() {
        println("姓名:$name,年龄:$age,工作:$info")
    }
}

class B(
    var name: String = "",
    var age: Int = 1,
    var info: String = ""
)//TODO 这个括号就是主构造函数，能声明参数并可以直接使用成员，不需要接收
{
    fun show() {
        println("姓名:$name,年龄:$age,工作:$info")
    }
}

class C(var name: String = "")//TODO 这个括号就是主构造函数，能声明参数并可以直接使用成员，不需要接收
{
    /**
     * 下面是 init 代码块
     */
    init {
        println("init $name")
    }

    /**
     * 下面是次构造
     */
    constructor(name: String = "", age: Int = 1) : this(name) {
        println("naem:$name , age:$age")
    }

    constructor(name: String = "", age: Int = 1, gender: Short = 1) : this(name) {
        println("naem:$name , age:$age gender:$gender")
    }
}

/**
 * 继承父类如果父类有主构造，要调用父类的主构造
 * 如果在继承时，不调用父类的主构造，就要在子类的次构造里调用父类的主构造函数
 */
class MyView : View {
    constructor(ctx: Context) : this(ctx, null) {

    }

    constructor(ctx: Context, attr: AttributeSet? = null) : this(ctx, attr, 0) {

    }

    constructor(ctx: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0) : super(
        ctx,
        attr,
        defStyleAttr
    ) {

    }
}

class D(
    _name: String = "",
    _info: String = "",
    _age: Int = -1
)//TODO 这个括号就是主构造函数，能声明参数，不能直接使用，需要接收后才能用
{
    init {
        println(_name)
        //使用 require 校验参数
        require(_name.isNotBlank()) { "name 不能为空" }
        require(_age > 0) { "age 必须 >0" }
    }

    val name = _name
    val info = _info
    val age = _age
    fun show() {
        println("姓名:$name,年龄:$age,工作:$info")
    }
}


fun main() {
    var a = A("whl", "软件开发工程师", 33)
    a.show()
    var a2 = A(_name = "haha")
    a2.show()

    var b = B()
    b.show()
    var b2 = B("haha", 33, "扫地的")
    b2.show()

    var c = C()//构造函数参数有默认值 会调用主构造
    var c1 = C("whl")//调用一个参数的构造方法 也就是主构造
    var c2 = C("whl2", 33)//调用两个参数的次构造方法
    var c3 = C("whl3", 33, 1)//调用三个参数的次构造方法

    /**
     * init 代码块
     */
    var d = D("whl", _age = 33)

}