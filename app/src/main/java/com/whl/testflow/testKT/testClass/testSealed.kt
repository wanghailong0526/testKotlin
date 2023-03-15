package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * sealed 密封类
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
