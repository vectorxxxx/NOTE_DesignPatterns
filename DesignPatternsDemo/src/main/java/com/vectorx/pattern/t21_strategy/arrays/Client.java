package com.vectorx.pattern.t21_strategy.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Client {
    public static void main(String[] args) {
        Integer[] data = {9, 1, 2, 8, 4, 3};

        // 1. 匿名类对象`new Comparator<Integer>() {}`实现了`Comparator`接口（策略接口），
        // 2. `public int compare(Integer o1, Integer o2) {}`指定具体的处理方式
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        };
        /*
        public static <T> void sort(T[] a, Comparator<? super T> c) {
            if (c == null) {
                sort(a);
            } else {
                if (LegacyMergeSort.userRequested)
                    legacyMergeSort(a, c);
                else
                    TimSort.sort(a, 0, a.length, c, null, 0, 0);
            }
        }
        */
        // 方式1
        Arrays.sort(data, comparator);
        System.out.println(Arrays.toString(data));
        // [1, 2, 3, 4, 8, 9]

        //方式2
        Arrays.sort(data, (v1, v2) -> v1.compareTo(v2) > 0 ? -1 : 1);
        System.out.println(Arrays.toString(data));
        //[9, 8, 4, 3, 2, 1]
    }
}
