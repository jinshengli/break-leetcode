
/**
 * create by ljs on 2020/6/8 8:11
 *
 * 题目描述： 返回每个滑动窗口的最大值。
 *
 * 1） 暴力： 遍历每个 k 大小的滑动窗口； 求出最大值。
 *
 *
 *
 */
public class MaxSlidingWindow_239 {



    public int[] maxSlidingWindow(int[] nums, int k) {

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




}
