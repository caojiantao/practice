package com.cjt.practice.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author caojiantao
 */
public class Heap {

    public static int[] sort(int[] data) {
        // 从最后一个叶子节点向前遍历
        for (int s = data.length / 2; s >= 0; s--) {
            heapAdjust(data, data.length, s);
        }
        int heapSize;
        for (int i = 0; i < data.length; i++) {
            // 建立指定大小堆
            heapSize = data.length - i;
            heapAdjust(data, heapSize, 0);
            // 交换数组首尾
            Util.exchange(data, 0, heapSize - 1);
        }
        return data;
    }

    private static void heapAdjust(int[] data, int heapSize, int i) {
        int maxIndex = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < heapSize && data[i] < data[left]) {
            maxIndex = left;
        }
        if (right < heapSize && data[maxIndex] < data[right]) {
            maxIndex = right;
        }
        // 当有节点交换时，破坏完全二叉树结果，递归到交换的子节点
        if (maxIndex != i) {
            Util.exchange(data, i, maxIndex);
            heapAdjust(data, heapSize, maxIndex);
        }
    }
}
