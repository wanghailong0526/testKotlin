package com.whl.testflow.testKT;

/**
 * @author : wanghailong
 * @date :
 * @description: TODO
 */
class TestJvmStaticjava {
    public static void main(String[] args) {
        //java 调用 Kt 的不加 jvmoverloads 注解的方法
        System.out.printf("", Student.Companion.getName());
        Student.Companion.show();

        //java 调用 Kt 的加 jvmoverloads 注解的方法
        System.out.println(Student.gender);
        Student.showInfo();
    }
}
