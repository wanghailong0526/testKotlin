package com.whl.testflow.testKT;

/**
 * @author : wanghailong
 * @date :
 * @description: TODO
 */
public class TestJvmOverloadsjava {
    public static void main(String[] args) {
//        TestJvmOverloadsKt.show("whl");//报错 因为 kt 有两个方法，这里必须传递两个参数，不能使用第二个参数的默认值
        TestJvmOverloadsKt.showInfo("whl");//Kt 方法上添加 @JvmOverloads 注解后成功
    }
}
