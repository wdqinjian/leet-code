package com.qj.sort;

/**
 * @author qinjian
 */
public class SelectSort extends Sort {


    @Override
    protected void sort() {
        int length = this.array.length;

        for (int i = length - 1; i > 0; i--) {
            int min = 0;
            // 每次都拿 第0个 和 从1到最后排好序的 进行比较， 把最大的放在后面
            for (int j = 1; j <= i; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }
}