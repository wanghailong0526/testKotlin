package com.whl.testflow.testKT.testHeighterOrderFun

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 *
 */
//点击事件
class ClickListener<T> {
    private var actions = arrayListOf<(T?) -> Unit>()
    private var values = arrayListOf<T?>()

    fun addListener(value: T?, action: (T?) -> Unit) {
        if (!actions.contains(action)) {
            actions += action;
            values += value;
        }
    }

    fun touchListener() {
        if (actions.isEmpty()) {
            println("无事件")
            return
        }
        actions.forEachIndexed { index, action ->
            action.invoke(values[index])
        }
    }


}

fun main() {
    var clickListener = ClickListener<String>()
    clickListener.touchListener()

    clickListener.addListener("1") {
        println("事件 $it 被执行")
    }
    clickListener.addListener("2") {
        println("事件 $it 被执行")
    }
    clickListener.addListener("3") {
        println("事件 $it 被执行")
    }

    clickListener.touchListener()
}