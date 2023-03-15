package com.whl.testflow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * @date  : 2022/11/22 14:01
 * @author: wanghailong
 *
 * @description:flow 操作符
 *
 */
/**
 * collect: 触发流开始工作 默认情况下与 flow 工作在同一个协程中,若 collect 中的代码未执行完，flow 中的代码也被挂起等待。
 *  意思是，如果 collect 中处理数据需要一秒，flow 中就要等待一秒
 *
 * 1.map: 将一个值映射成另一个值
 *
 * 2.filter: 过滤数据 在 filter 中指定条件
 *
 * 3.onEach: 遍历每一条数据，用于查看中间结果
 *
 * 4.debounce: 确保 flow 发送的各项数据之间存在一定的时间间隔；如果时间点过于临近的数据只保存最后一条
 *  使用场景:浏览器地址栏输入数据后，下方给出的搜索建议是从服务器实时获取的，
 *      如果用户每输入一个字符就要请求一次服务器是不合理的，
 *      应该在一定时间的停顿之后再发起网络请求，使用 debounce 函数实现
 *      debounce(500):当两条数据间隔超过 500 毫秒才会发送成功
 *
 * 5.sample:在 flow 数据流中，按照一定的时间间隔采样一条数据
 *  使用场景:某些数据源量很大，但只需要少量数据时很有用
 *  应用：视频的弹幕，每秒最多显示一条弹幕数据
 *
 * 终端操作函数:不需要借助 collect 函数，自己就能终结 flow 流程,后面不可以再接其它的操作符函数，只能获取最终的结果
 * 6.reduce: 公式: flow.reduce{ acc, currentValue -> acc + currentValue}
 *  通过参数给我们一个 flow 的累积值和一个 flow 的当前值，我们可以在 reduce 的函数体中做运算
 *      运算的结果会作为下一个累积值传到 reduce 函数中
 *  应用:1到100的累加和,字符串拼接
 *
 * 7.fold:公式: flow.fold(initial){ acc, value -> acc + value}
 *      作用与 reduce 函数一样，只是需要一个初始值
 *
 *  flatMap系列的操作符将两个 flow 压成一个 flow,最后再进行输出
 *
 * 8.flatMapConcat:多个 flow 拼接 保证结果顺序
 *      场景: 一个网络请求依赖于另一下网络请求的情况
 *
 * 9.flatMapMerge:多个 flow 合并 内部使用并发处理数据 不保证结果顺序
 *
 * 10.flatMapLatest: flow1 中的数据传到 flow2 中会立刻处理，
 *      如果 flow1 中的数据要发送了，flow2 中的上一个数据还未处理完，
 *      则直接将上一个数据处理逻辑取消，开始处理最新数据
 *
 * 11.zip: flatMap系列是多个 flow 串行，一个流流向另一个流； zip 是多个 flow 并行,合并
 *      规则:一个 flow 中的数据全部处理完就终止运行，另一个 flow 中剩余未处理的数据不会得到处理
 *      运行时间:取决于运行时间最久的那个 flow
 *      场景:多个接口同时返回之后才能将数据展示给用户
 *
 * 12.buffer:一种背压的处理策略，提供一份缓存区，当Flow数据流速不均匀的时候，使用这份缓存区来保证程序运行效率
 *      flow函数只管发送自己的数据，它不需要关心数据有没有被处理，反正都缓存在buffer当中
 *      使用在 flow 与 collect 中间,使 flow 中的数据发送不受 collect 数据处理速度的影响;
 *      使 flow 与 collect 工作在不同的协程中
 *      但是，如果流速不均匀问题持续放大，缓存区的内容越来越多时又该怎么办呢？
 *      这个时候，我们又需要引入一种新的策略了，来适当地丢弃一些数据。
 *      那么进入到本篇文章的最后一个操作符函数：conflate。
 *      buffer(10,BufferOverflow.SUSPEND):buffer 容量为10，超过容量后默认处理方式为 BufferOverflow.SUSPEND
 *
 * 13.conflate: 当有更新的数据发送过来时，旧的数据被舍弃
 *      buffer函数最大的问题在于，
 *      不管怎样调整它缓冲区的大小（buffer函数可以通过传入参数来指定缓冲区大小），
 *      都无法完全地保障程度的运行效果。究其原因，主要还是因为buffer函数不会丢弃数据。
 *      场景：
 *      比如拿股票软件举例，服务器端会将股票价格的实时数据源源不断地发送到客户端这边，
 *      而客户端这边只需要永远显示最新的股票价格即可，将过时的数据展示给用户是没有意义的。
 */
/**
 * filter
 * onEach
 * map
 */
//fun main() {
//    runBlocking {//提供协程作用域给 flow 使用，代码块中的代码执行完之前会阻塞当前线程
//        val flow = flowOf(1, 2, 3, 4, 5)
//        flow.filter {
//            it % 2 == 0//过虑偶数
//        }.onEach {
//            println("过虑后的数据：$it")
//        }.map {
//            it * it
//        }.collect {
//            println(it)
//        }
//    }
//}

/**
 * debounce
 */
//fun main() {
//    runBlocking {
//        //2和3之间间隔600毫秒,所以2发送成功;3，4，5之间间隔100毫秒，所以3，4失败,5是最后一个数据，因此 5 成功
//        flow {
//            emit(1)
//            emit(2)
//            delay(600)
//            emit(3)
//            delay(100)
//            emit(4)
//            delay(100)
//            emit(5)
//        }
//            .debounce(100)
//            .collect {
//                println(it)//打印结果是2和5
//            }
//    }
//}

/**
 * sample
 * 通过死循环发送数据，所以使用 flowOn(Dispatchers.IO)
 * 在 IO 线程里执行，否则一直阻塞主线程
 */
//fun main() {
//    runBlocking {
//        flow {
//            while (true) {
//                emit("发送一条弹幕")
//            }
//        }
//            .sample(1000)
//            .flowOn(Dispatchers.IO)
//            .collect {
//                println(it)
//            }
//    }
//}
/**
 * reduce
 */
//fun main() {
//    runBlocking {
//        val r = flow {
//            for (i in 1..100) {
//                emit(i)
//            }
//        }
//            .reduce { acc, value ->
//                println("acc = $acc,value = $value")
//                acc + value
//            }
//        println(r)
//    }
//}
/**
 * fold
 */
//fun main() {
//    runBlocking {
//        val r = flow {
//            for (i in ('A'..'Z')) {
//                emit(i)
//            }
//        }
//            .fold("A加到Z = ") { acc, value -> acc + value }
//        println(r)
//    }
//}
/**
 * flatMapConcat
 */
//fun main() {
//    runBlocking {
//        flowOf(1, 2)
//            .flatMapConcat {
//                flowOf("a$it", "b$it")
//            }
//            .collect {
//                println(it)//输出 a1 b1 a2 b2
//            }
//    }
//}

/**
 * flatMapConcat 应用场景  请求用户数据的接口需要先请求用户 token
 */
////请求 token
//fun getTokenRequest(): Flow<String> = flow {
//    emit("token")
//}
//
////请求用户信息
//fun getUserInfoRequest(token: String): Flow<String> = flow {
//    emit("userInfo")
//}
//
//fun main() {
//    runBlocking {
//        getTokenRequest()
//            .flatMapConcat { token ->
//                getUserInfoRequest(token)
//            }
//            .flowOn(Dispatchers.IO)
//            .collect { userInfo ->
//                //获取到用户信息
//                println(userInfo)
//            }
//    }
//}
/**
 * flatMapConcat 执行结果顺序 demo
 * 即使第一个数据 delay 时间最长，后面的数据也没有优先执行权
 */
//fun main() {
//    runBlocking {
//        flowOf(300, 200, 100)
//            .flatMapConcat {
//                flow {
//                    delay(it.toLong())
//                    emit("a$it")
//                    emit("b$it")
//                }
//            }
//            .collect {
//                println(it)//输出 a300 b300 a200 b200 a100 b100
//            }
//    }
//}
/**
 * flatMapMerge 并发合并数据，谁的 delay 时间越短越优先执行
 */
//fun main() {
//    runBlocking {
//        flowOf(300, 200, 100)
//            .flatMapMerge {
//                flow {
//                    delay(it.toLong())
//                    emit("a$it")
//                    emit("b$it")
//                }
//            }
//            .collect {
//                println(it)//输出 a100 b100 a200 b200 a300 b300
//            }
//    }
//}
/**
 * flatMapLatest
 * 发送1给 flow2 并 delay(150), flow2 收到delay(100) 成功
 * 发送2给 flow2 并 delay(50), flow2 收到delay(100)
 * 发送3给 flow2，此时 flow2 上一个数据 2 还没有处理完，所以取消了2的处理逻辑，直接处理数据 3
 * 输出 1，3
 */
//fun main() {
//    runBlocking {
//        flow {
//            emit(1)
//            delay(150)
//            emit(2)
//            delay(50)
//            emit(3)
//        }
//            .flatMapLatest {
//                flow {
//                    delay(100)
//                    emit("$it")
//                }
//            }
//            .collect {
//                println(it)//输出 1 3
//            }
//    }
//}
/**
 * zip
 * 输出 a1 b2 c3
 * flow2 中的 4，5，6被舍弃了
 */
//fun main() {
//    runBlocking {
//        val flow1 = flowOf("a", "b", "c")
//        val flow2 = flowOf(1, 2, 3, 4, 5, 6)
//        flow1.zip(flow2) { a, b ->
//            a + b
//        }
//            .collect {
//                println(it)
//            }
//    }
//}
/**
 * zip 应用
 */
////实时天气数据
//fun realtimeWeatherRequest(): Flow<String> = flow {
//    emit("realtimeWeather")
//}
//
////七天天气数据
//fun SevenDaysWeatherRequest(): Flow<String> = flow {
//    emit("sevenDaysWeather")
//}
//
////天气背景图
//fun weatherBackground(): Flow<String> = flow {
//    emit("watherBackground")
//}
//
//fun main() {
//    var weather: Weather = Weather()
//    runBlocking {
//        realtimeWeatherRequest()
//            .zip(SevenDaysWeatherRequest()) { realtimeWeather, sevenDaysWeather ->
//                weather.realtimeWeather = realtimeWeather
//                weather.sevenDaysWeather = sevenDaysWeather
//                weather//返回值
//            }
//            .zip(weatherBackground()) { weather, weatherBackground ->
//                weather.weatherBackground = weatherBackground
//                weather
//            }.collect { weather ->
//                println("weather.realtimeWeather =  ${weather.realtimeWeather}")
//                println("weather.sevenDaysWeather =  ${weather.sevenDaysWeather}")
//                println("weather.weatherBackground =  ${weather.weatherBackground}")
//            }
//    }
//}
/**
 * buffer
 * 使 flow 与 collect 工作在不同的协程
 * 数据发送与数据处理互不干扰
 */
//fun main() {
//    runBlocking {
//        flow {
//            emit(1)
//            delay(1000)
//            emit(2)
//            delay(1000)
//            emit(3)
//        }
//            .onEach {
//                println("$it ready")
//            }
//            .buffer(10, BufferOverflow.SUSPEND)//buffer 容量为10，超过的数据处理方式为suspend
//            .collect {
//                delay(1000)
//                print("$it done")
//            }
//    }
//}
/**
 * conflate
 * 新数据来了，旧数据未处理完，将旧数据处理逻辑舍弃
 */
//fun main() {
//    runBlocking {
//        flow {
//            var count = 0
//            while (true) {
//                emit(count)
//                delay(1000)
//                count++
//            }
//        }
//            .conflate()
//            .collect {
//                println("start $it")
//                delay(2000)
//                println("done $it")
//            }
//    }
//}



