package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * sealed 密封类
 * 密封类用来表示受限的类继承结构：
 * 当一个值为有限几种的类型、而不能有任何其他类型时。
 * 在某种意义上，他们是枚举类的扩展：枚举类型的值集合也是受限的，
 * 但每个枚举常量只存在一个实例，
 * 而密封类的一个子类可以有可包含状态的多个实例。
 * 1.成员必须有类型
 * 2.必须继承本类
 */
sealed class Score2 {
    object GOOD1 : Score2()//单例
    object GOOD2 : Score2()
    object GOOD3 : Score2()
    class GOOD4(var studentName: String) : Score2()//类
}

class Teacher2(val score: Score2) {
    fun show() =
        when (score) {
            is Score2.GOOD1 -> "不及格"
            is Score2.GOOD2 -> "及格"
            is Score2.GOOD3 -> "良好"
            is Score2.GOOD4 -> "优秀学生的名字:${this.score.studentName}"
        }
}

fun main() {
    println(Teacher2(Score2.GOOD1).show())
    println(Teacher2(Score2.GOOD2).show())
    println(Teacher2(Score2.GOOD3).show())
    println(Teacher2(Score2.GOOD4("whl")).show())
}
