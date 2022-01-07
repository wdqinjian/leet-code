package com.qj.sort;

/**
 * @author qinjian
 */
public class InsertSort extends Sort {

    @Override
    protected void sort() {

        int length = this.array.length;

        // i往前都是排好序的
        for (int i = 1; i < length; i++) {
            int cur = i;
            // 存起来
            int temp = array[cur];
            // 拿cur 和 前面已排好序的做比较
            while (cur > 0 && temp > array[cur - 1]) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = temp;
        }

    }


    protected void sort1() {
        int length = this.array.length;
        // i往前都是排好序的
        for (int i = 1; i < length; i++) {
            int cur = i;
            // 拿cur 和 前面已排好序的做比较
            while (cur > 0 && array[cur] > array[cur - 1]) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}