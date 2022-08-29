package monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * create by ljs on 2020/6/8 8:11
 *
 * 题目描述： 返回每个滑动窗口的最大值。
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 1） 暴力： 遍历每个 k 大小的滑动窗口； 求出最大值。
 *
 *
 *
 */
public class MaxSlidingWindow_239 {



    // 暴力求解
    public int[] maxSlidingWindow01(int[] nums, int k) {

        int []res = new int[nums.length-k+1];
        int count = 0;

        for( int i = 0; i < nums.length - k + 1 ; ++i ){

            int max_t = nums[i];
            for ( int j = i ; j < i + k; ++j ){  // 第一次出现问题： 滑动窗口的结束位置。

                max_t = Math.max(max_t, nums[j]);

            }
            res[count++] = max_t;
        }
        return res;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int index = 0;
        ans[index++] = deque.peekFirst();
        for (int i = k; i < nums.length; ++i) {
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            ans[index++] = deque.peekFirst();
        }
        return ans;
    }

    public int[] maxSlidingWindow001(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (i >= k - 1) {
                ans[index++] = deque.peekFirst();
                if (nums[i - k + 1] == deque.peekFirst()) {
                    deque.pollFirst();
                }
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow002(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    /**
     *   Deque<Integer> d = new ArrayDeque<>();
     *         int n = nums.length, m = n - k + 1;
     *         int[] ans = new int[m];
     *         for (int i = 0; i < n; i++) {
     *             while (!d.isEmpty() && nums[d.peekLast()] <= nums[i]) d.pollLast();
     *             d.addLast(i);
     *             if (i >= k - 1) {
     *                 while (!d.isEmpty() && d.peekFirst() <= i - k) d.pollFirst();
     *                 ans[i - k + 1] = nums[d.peekFirst()];
     *             }
     *         }
     *         return ans;
     */



}
