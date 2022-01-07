package com.qj.sort;

import java.util.Arrays;

/**
 * @author qinjian
 */
public abstract class Sort {

    protected int[] array;

    public void sort(int[] array) {

        if (array == null || array.length < 2) {
            return;
        }

        this.array = array;

        long begin = System.currentTimeMillis();
        sort();
        long spend = System.currentTimeMillis() - begin;
        System.out.println("耗时  ： " + spend);
    }


    protected abstract void sort();

    protected void swap(int i, int j) {
        int tmep = array[i];
        array[i] = array[j];
        array[j] = tmep;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}