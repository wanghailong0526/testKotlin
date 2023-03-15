package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * inner
 * 1.当类嵌套时，外部类能访问内部类，内部类无法访问外部类，需要在内部类声明头部添加 inner 声明为内部类 才能访问外部类的成员
 * 2.外部类调用内部类
 *      外部类().内部类().成员
 */
class AA {

    var body: String = "是身体的一部分"
    var ss = BB().s//外部类可以访问内部类成员

    inner class BB {
        var s = body //若不添加 inner 就会找不到 info
    }

    inner class Hand {
        inner class LeftHand {
            fun show() {
                println("左手${body}")
            }
        }

        inner class RightHand {
            fun show() {
                println("右手${body}")
            }
        }
    }
}

fun main() {
    println(AA().BB().s)
    AA().Hand().LeftHand().show();
    AA().Hand().RightHand().show();
}