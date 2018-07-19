package com.cjt.practice.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * 源码、反码、补码计算
 *
 * @author caojiantao
 */
public class NumberConversion {

    public static void main(String[] args) {
        System.out.println(formatResult(getBinary(-10)));
        System.out.println(formatResult(getInverse(-10)));
        System.out.println(formatResult(getComplement(-10)));
    }

    /**
     * 获取原码
     */
    private static String getBinary(int number) {
        StringBuilder builder = new StringBuilder(Integer.SIZE);
        List<Integer> indexs = new ArrayList<>();
        initIndexs(Math.abs(number), indexs);
        boolean isNegative = number < 0;
        for (int index = Integer.SIZE - 1; index >= 0; index--) {
            if (index == Integer.SIZE - 1) {
                // 符号位
                builder.append(isNegative ? 1 : 0);
            } else {
                builder.append(indexs.contains(index) ? 1 : 0);
            }
        }
        return builder.toString();
    }

    /**
     * 获取反码
     */
    private static String getInverse(int number) {
        String result = getBinary(number);
        if (number < 0) {
            StringBuilder builder = new StringBuilder();
            for (int index = 0; index < result.length(); index++) {
                if (index == 0) {
                    builder.append(result.charAt(index));
                } else {
                    builder.append(result.charAt(index) == '1' ? "0" : "1");
                }
            }
            result = builder.toString();
        }
        return result;
    }

    /**
     * 获取补码
     */
    private static String getComplement(int number) {
        String result = getBinary(number);
        if (number < 0) {
            // 获取负数补码
            String inverse = getInverse(number);
            // 补码加1取二进制，注意这里是转换为负数，数值计算是减1
            result = getBinary(getInteger(inverse) - 1);
        }
        return result;
    }

    private static void initIndexs(int number, List<Integer> indexs) {
        if (number != 0) {
            int index = 0;
            while (Math.pow(2, index) <= number) {
                index++;
            }
            // 后退一位
            index--;
            indexs.add(index);
            initIndexs(number - (int) Math.pow(2, index), indexs);
        }
    }

    /**
     * 四个数字为间隔，格式化二进制字符串
     */
    private static String formatResult(String result) {
        int len = 4;
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < result.length(); index++) {
            builder.append(result.charAt(index));
            if ((index + 1) % len == 0) {
                // 每间隔一段添加一个空格
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * 二进制字符串转换数字
     */
    private static int getInteger(String result) {
        int sum = 0;
        for (int index = 1; index < result.length(); index++) {
            if (result.charAt(index) == '1') {
                sum += Math.pow(2, result.length() - 1 - index);
            }
        }
        // 注意符号位
        return result.charAt(0) == '1' ? -sum : sum;
    }
}
