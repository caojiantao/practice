package com.cjt.practice.sort;

/**
 * 归并排序
 *
 * @author caojiantao
 */
public class Merge {

    public static void sort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(data, left, mid);
            sort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    private static void merge(int[] data, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        // 临时归并数组
        int[] temp = new int[right - left + 1];
        // i为左表游标，j为右表游标，k为临时表游标
        while (i <= mid && j <= right) {
            if (data[i] < data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        // 左表未扫描完
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        // 右表未扫描完
        while (j <= right) {
            temp[k++] = data[j++];
        }
        // 将归并后的数组回写到原始数组中
        System.arraycopy(temp, 0, data, left, temp.length);
    }
}