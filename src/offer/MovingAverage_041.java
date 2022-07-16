package offer;


import java.util.LinkedList;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 *
 * 实现 MovingAverage 类：
 *
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 *
 * 1 <= size <= 1000
 * -10^5 <= val <= 10^5
 * 最多调用 next 方法 10^4 次
 *
 *
 *
 */
public class MovingAverage_041 {

    private LinkedList<Integer> queue;
    private int maxSize;
    private double totalSum;

    /** Initialize your data structure here. */
    public MovingAverage_041(int size) {
        queue = new LinkedList<>();
        maxSize = size;
        totalSum = 0;
    }

    public double next(int val) {
        if (queue.size() >= maxSize) {
            totalSum -= queue.poll();
        }
        totalSum += val;
        queue.offer(val);
        return totalSum/(queue.size()*1.0);
    }

}




/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */