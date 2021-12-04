package com.qj;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        // small 按照从大到小排序
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        // lagre 按照插入的顺序，  因插入是从小到大的，因此是小到大的排序
        large = new PriorityQueue<>();
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        finder.addNum(10);
        finder.addNum(9);
        finder.addNum(7);

        System.out.println(finder.findMedian());
    }

    /**
     * 添加元素
     * <p>
     * 维护了两个优先级队列，  保证了数据从小到大的排序， 一半最小的数据在 small, 一半更大的数据在large
     *
     * @param num
     */
    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    /**
     * 获取队列的中位数
     *
     * @return
     */
    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;
    }
}