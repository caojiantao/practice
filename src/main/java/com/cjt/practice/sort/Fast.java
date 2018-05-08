package com.cjt.practice.sort;

/**
 * 快速排序
 *
 * @author caojiantao
 */
public class Fast {

    /**
     * 类似二分法，递归调用
     */
    public static void sort(int[] data, int start, int end) {
        if (start < end) {
            int i = start, j = end;
            int key = data[i];
            while (i < j) {
                while (j > i && data[j] >= key) {
                    j--;
                }
                Util.exchange(data, i, j);
                while (i < j && data[i] < key) {
                    i++;
                }
                Util.exchange(data, i, j);
            }
            sort(data, start, i - 1);
            sort(data, j + 1, end);
        }
    }
}
