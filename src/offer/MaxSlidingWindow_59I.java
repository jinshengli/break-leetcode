package offer;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 *
 *  使用双端队列维持一个单调递减队列
 *
 */

public class MaxSlidingWindow_59I {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if ( nums == null || nums.length == 0 || k == 0 )
            return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length-k+1];

        for ( int i = 0; i < k; ++i ) {
            while ( !deque.isEmpty() && deque.getLast() < nums[i] )
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        result[0] = deque.getFirst();
        for ( int i = k; i < nums.length; ++i ) { // 向右滑动一个格子
            if ( deque.getFirst() == nums[i-k] )
                deque.removeFirst();
            while ( !deque.isEmpty() && deque.getLast() < nums[i] )
                deque.removeLast();
            deque.addLast(nums[i]);
            result[i-k+1] = deque.getFirst();
        }
        return result;
    }

}
