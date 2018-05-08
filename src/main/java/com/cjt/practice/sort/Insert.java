package com.cjt.practice.sort;

/**
 * 插入排序
 *
 * @author caojiantao
 */
public class Insert {

    public static int[] sort(int[] data) {
        int i, j, key;
        for (j = 1; j < data.length; j++) {
            // 定义插值数据
            key = data[j];
            for (i = j - 1; i >= 0; i--) {
                if (data[i] > key) {
                    data[i + 1] = data[i];
                } else {
                    break;
                }
            }
            // 插值操作
            data[i + 1] = key;
        }
        return data;
    }
}
