package com.whl.testflow.testKT;

/**
 * @author : wanghailong
 * @date :
 * @description: TODO
 */
public class testString {
    public static void main(String[] args) {
        String s = "Whl";
        String s2 = "Whl";
        String s3 = new String("Whl");
        System.out.println(s.equals(s2));
        System.out.println(s == s2);
        System.out.println(s3.equals(s2));
        System.out.println(s3 == s2);
    }
}
