package com.cjt.practice.exam;

/**
 * @author caojiantao
 */
public class BigNum {

    public static void main(String[] args) {
        String a = "88888888888888888888";
        String b = "8888888888888888888";
        // 差位补0
        int sub = a.length() - b.length();
        if (sub < 0) {
            while (sub != 0) {
                a = "0".concat(a);
                sub++;
            }
        } else {
            while (sub != 0) {
                b = "0".concat(b);
                sub--;
            }
        }
        // 进位
        int high = 0;
        int m, n, result;
        StringBuilder builder = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            m = Integer.parseInt(String.valueOf(a.charAt(i)));
            n = Integer.parseInt(String.valueOf(b.charAt(i)));
            result = m + n + high;
            builder.insert(0, result % 10);
            high = result / 10;
        }
        if (high != 0) {
            builder.insert(0, high);
        }
        System.out.println(builder.toString());
    }
}
