package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * create by ljs on 2020/7/20 19:51
 * description:
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 */
public class MaxSlidingWindow_59 {

    /**
     *     使用最大堆；堆大小为k.
     *
     *     初始化堆大小为 k
     *
     *     对于要进堆
     *      1. 移除滑动窗口前面的一个元素
     *      2. 进来一个元素，调整堆
     *      3. 输出一个堆顶元素
     * @param nums
     * @param k
     * @return
     */

    //自定义比较器，降序排列
    static Comparator<Integer> cmp = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    };

    public int[] maxSlidingWindow(int[] nums, int k) {

        if ( nums == null || nums.length <= 1 ) {
            return nums;
        }

        //
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(cmp);

        int []result = new int[nums.length-k+1];

        for ( int i = 0; i < k && i < nums.length; ++i )
            priorityQueue.add(nums[i]);
        int index = 0;
        result[index++] = priorityQueue.peek();

        for ( int i = k; i < nums.length; ++i ) {
             // 排除滑动窗口前的一个元素
            priorityQueue.remove(nums[i-k]);
            priorityQueue.add(nums[i]);
            Integer peek = priorityQueue.peek();
            result[index++] = peek;
        }

        return result;
    }


}
