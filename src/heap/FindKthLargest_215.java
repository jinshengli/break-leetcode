package heap;

import java.util.Arrays;

/**
 * create by ljs on 2020/7/25 23:25
 * description:
 *
 *      215. 数组中的第K个最大元素
 *
 *      1 2 3 4 5 6
 *
 */
public class FindKthLargest_215 {


    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length-k];

    }

}
