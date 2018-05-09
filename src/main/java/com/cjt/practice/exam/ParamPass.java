package com.cjt.practice.exam;

/**
 * Java只有值传递，没有引用传递
 *
 * @author caojiantao
 */
public class ParamPass {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("aaa");
        b(builder);
        System.out.println(builder.toString());
        c(builder);
        System.out.println(builder.toString());
    }

    private static void b(StringBuilder builder) {
        builder = new StringBuilder("bbb");
    }

    private static void c(StringBuilder builder) {
        builder.append("ccc");
    }
}
