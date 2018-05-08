package com.cjt.practice.sort;

/**
 * 冒泡排序
 *
 * @author caojiantao
 */
public class Bubble {

    public static int[] sort(int[] data) {
        int len = data.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    Util.exchange(data, j, j + 1);
                }
            }
        }
        return data;
    }
}
