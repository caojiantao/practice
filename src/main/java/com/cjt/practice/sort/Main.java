package com.cjt.practice.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author caojiantao
 */
public class Main {

    public static void main(String[] args) {
        int[] arr;
        long s, e;

        s = System.currentTimeMillis();
        arr = getTestArr();
        System.out.println(Arrays.toString(Bubble.sort(arr)));
        e = System.currentTimeMillis();
        System.out.println("冒泡排序耗时：" + (e - s) + "ms");

        s = e;
        arr = getTestArr();
        Fast.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        e = System.currentTimeMillis();
        System.out.println("快速排序耗时：" + (e - s) + "ms");

        s = e;
        arr = getTestArr();
        System.out.println(Arrays.toString(Heap.sort(arr)));
        e = System.currentTimeMillis();
        System.out.println("堆排序耗时：" + (e - s) + "ms");

        s = e;
        arr = getTestArr();
        System.out.println(Arrays.toString(Insert.sort(arr)));
        e = System.currentTimeMillis();
        System.out.println("插入排序耗时：" + (e - s) + "ms");

        s = e;
        arr = getTestArr();
        Merge.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        e = System.currentTimeMillis();
        System.out.println("归并排序耗时：" + (e - s) + "ms");

        s = e;
        arr = getTestArr();
        System.out.println(Arrays.toString(Radix.sort(arr)));
        e = System.currentTimeMillis();
        System.out.println("基数排序耗时：" + (e - s) + "ms");

        s = e;
        arr = getTestArr();
        System.out.println(Arrays.toString(Select.sort(arr)));
        e = System.currentTimeMillis();
        System.out.println("选择排序耗时：" + (e - s) + "ms");

        s = e;
        arr = getTestArr();
        System.out.println(Arrays.toString(Shell.sort(arr)));
        e = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (e - s) + "ms");
    }

    private static int[] getTestArr() {
        int size = 10000;
        int[] temp = new int[size];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new Random().nextInt(size);
        }
        return temp;
    }
}
