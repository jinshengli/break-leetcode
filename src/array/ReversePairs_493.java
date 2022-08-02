package array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 *
 */
public class ReversePairs_493 {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;
        int ans = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        return ans + countReversePairs(nums, left, mid, right);
    }


    // 如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
    private int countReversePairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int i = left, j = mid + 1;
        while (i <= mid) {
            while (j <= right && (long)nums[i] > (long) nums[j] * 2) {
                j++;
            }
            count += (j - mid - 1);
            i++;
        }
        Arrays.sort(nums, left, right + 1);
        return count;
    }


    // 如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
    // 这样会超时
    private int countReversePairs01(int[] nums, int left, int mid, int right) {
        int count = 0;
        int i = left;
        while (i <= mid) {
            for (int j = mid + 1; j <= right; ++j) {
                // (long)nums[i] > (long) (nums[j]*2) 这样不行哦
                if ((long)nums[i] > (long) (nums[j]*2L) ) {
                    count++;
                }
            }
            i++;
        }
        Arrays.sort(nums, left, right+1);
        return count;
    }

    public static void main(String[] args) {
        ReversePairs_493 reversePairs_493 = new ReversePairs_493();
        int []nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int i = reversePairs_493.reversePairs(nums);
        System.out.println(i);

        int []num = {1,3,2,3,1};

        Arrays.sort(num, 0, num.length - 1);

        System.out.println(num);

        System.out.println(Integer.MAX_VALUE);

    }
}
