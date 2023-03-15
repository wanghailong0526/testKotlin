package com.whl.testflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.text_view)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            lifecycleScope.launch {
                //collect 函数是挂起函数 必须在协程作用域或挂起函数中调用
//                mainViewModel.timeFlow.collect { time ->
//                    delay(3000)
//                    textView.text = time.toString()
//                }
                /**
                 * 流速不均匀问题
                 * collectlatest 只接收最新的数据，新数据来了，旧数据未处理完则将旧数据的处理逻辑全部取消
                 */
                mainViewModel.timeFlow.collectLatest { time ->
                    textView.text = time.toString()
                    delay(3000)
                }
            }
        }
    }
}