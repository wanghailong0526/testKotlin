package com.whl.testflow.testKT.testFlow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description:
 *
 */
class MainViewModel : ViewModel() {
    val timeFlow = flow {
        var time = 0
        while (true) {
            emit(time)
            delay(1000)
            time++
        }
    }
}