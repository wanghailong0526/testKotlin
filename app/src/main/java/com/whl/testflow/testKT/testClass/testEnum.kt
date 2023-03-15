package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * enum 枚举 enum class Week{}
 * 1.enum 中的每个值都是 枚举类型
 * 2.enum 中定义函数
 *      1.主构造的参数必须和枚举值的参数保持一致
 *      2.一但枚举值有参数，那么就不能再定义单个的枚举值了，所有的枚举值必须保持一致
 *
 * 3.枚举值的更新
 *
 * 4.作为代数数据类型
 *  1.enum 作为代数数据类型，enum里的所有情况都用到了在when中不用写 else
 *
 *
 */
enum class Week {
    一, 二, 三, 四, 五, 六, 七;
}

data class BodyInfo(var name: String, var length: Int) {}

enum class Body(var bodyInfo: BodyInfo) {
    LEFT_HAND(BodyInfo("左手", 20)),
    RIGHT_HAND(BodyInfo("右手", 20)),

    LEFT_FOOT(BodyInfo("左脚", 20)),
    RIGHT_FOOT(BodyInfo("右脚", 20));

    fun getInfo() = "${bodyInfo.name}的长度是${bodyInfo.length}"

    /**
     * 更新枚举值
     */
    fun update(bodyInfo: BodyInfo) {
        this.bodyInfo.name = bodyInfo.name;
        this.bodyInfo.length = bodyInfo.length
    }
}

enum class Score {
    GOOD1,
    GOOD2,
    GOOD3,
    GOOD4;
}

class Teacher(var score: Score) {
    fun show() =
        when (score) {
            Score.GOOD1 -> "不及格"
            Score.GOOD2 -> "及格"
            Score.GOOD3 -> "良好"
            Score.GOOD4 -> "优秀"
        }
}

fun main() {
    println(Week.一)
    println(Week.二 is Week)//返回 true

    /**
     * 调用方法
     */
    println(Body.LEFT_HAND.getInfo())

    /**
     * 更新枚举的值
     */
    Body.RIGHT_HAND.update(BodyInfo("右手2", 88))
    println(Body.RIGHT_HAND.getInfo())

    /**
     * 代数数据类型
     */
    println(Teacher(Score.GOOD1).show())
    println(Teacher(Score.GOOD2).show())
    println(Teacher(Score.GOOD3).show())
    println(Teacher(Score.GOOD4).show())


}
