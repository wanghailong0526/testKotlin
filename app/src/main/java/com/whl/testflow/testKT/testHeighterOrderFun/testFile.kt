package com.whl.testflow.testKT

import java.io.File

/**
 *
 * @date   :
 * @author : wanghailong
 *
 * @description: TODO
 *
 */
fun main() {
    var path = "/Users/wanghailong/Downloads"
    val fileTree = File(path).walk()//获取文件目录
    fileTree.maxDepth(1)//遍历目录深度 为 1 表示不遍历子目录
        .filter {
            it.isFile
        }.filter {
            it.extension in listOf("txt")
        }.forEach {
            println(it)
        }
}