package com.cjt.practice.sort;

/**
 * 选择排序
 */
public class Select {

    public static int[] sort(int[] data) {
        int min, minIndex;
        for (int i = 0; i < data.length; i++) {
            min = data[i];
            minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    minIndex = j;
                }
            }
            Util.exchange(data, i, minIndex);
        }
        return data;
    }
}
