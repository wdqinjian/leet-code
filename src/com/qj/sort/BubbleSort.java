package com.qj.sort;

/**
 * @author qinjian
 */
public class BubbleSort extends Sort {


    @Override
    protected void sort() {

        int length = this.array.length;
        boolean sorted = true;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (array[j - 1] < array[j]) {
                    swap(j - 1, j);
                    sorted = false;
                }
            }

            // 如果这一轮没有交换过， 说明已经完全有序了
            if (sorted) {
                break;
            }
        }
    }

}