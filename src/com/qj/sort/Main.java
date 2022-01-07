package com.qj.sort;

public class Main {

    public static void main(String[] args) {
        int[] array = {3, 9, 6, 4, 1, 3, 4, 9, 2, 1, 66, 22, 11, 44, 75, 42, 1234, 553, 221, 221, 70};
        Sort bubbleSort = new InsertSort();
        bubbleSort.sort(array);
        System.out.println(bubbleSort);
    }
}