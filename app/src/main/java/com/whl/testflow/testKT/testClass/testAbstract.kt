package com.whl.testflow.testKT.testClass

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 * abstract class
 */
abstract class BaseActivity {
    fun onCreate() {
        setContentView(getLayout())
        initView()
        initData()
    }

    fun setContentView(layoutId: Int) {
        println("设置布局")
    }

    abstract fun getLayout(): Int
    abstract fun initView()
    abstract fun initData()
}

class MainActivity : BaseActivity() {
    override fun getLayout(): Int {
        return 1
    }

    override fun initView() {
        println("初始化 view")
    }

    override fun initData() {
        println("初始化数据")
    }

    fun show() = super.onCreate()
}

fun main() {
    MainActivity().show()
}