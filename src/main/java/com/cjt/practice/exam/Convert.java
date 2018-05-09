package com.cjt.practice.exam;

/**
 * @author caojiantao
 */
public class Convert {

    private static class Dog {
    }

    private static class Husky extends Dog {
    }

    public static void main(String[] args) {
        Husky husky = new Husky();
        // 子转父，隐式转换
        Dog dog = husky;
        // 父转子，显示强制转换
        husky = (Husky) dog;

        // 基本类型转换
        // short int long float double 从左至右转换，依次增大，隐式转换，反之显示强制转换
        short s = 1;
        int i = s;
        long l = i;
        float f = l;
        double d = f;
        f = (float) d;
    }
}
