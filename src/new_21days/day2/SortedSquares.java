package new_21days.day2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ljs
 * @since 2021/7/18 上午7:40
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 *
 *
 **/
public class SortedSquares {

    /**
     * 找到非负数的位置
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {

        if (nums == null || nums.length == 0)
            return nums;

        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0)
                break;
            index++;
        }

        int left = index-1; // 0 - left 代表负数的范围
        int right = index; // right - num.length -1 代表非负数范围
        int []ans = new int[nums.length];
        int a_index = 0;

        while (left >= 0 && right < nums.length) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                ans[a_index++] = nums[left]*nums[left];
                left--;
            } else {
                ans[a_index++] = nums[right]*nums[right];
                right++;
            }
        }

        while (left >= 0) {
            ans[a_index++] = nums[left]*nums[left];
            left--;
        }

        while (right < nums.length) {
            ans[a_index++] = nums[right]*nums[right];
            right++;
        }

        return ans;
    }

    /**
     * 找到
     * @param nums
     * @return
     */
    public static int[] sortedSquares01(int[] nums) {

        if (nums == null || nums.length == 0)
            return nums;

        int left = -1; // 0 - left 代表负数的范围

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0)
                break;
            left = i;
        }

        int right = left + 1;

        int []ans = new int[nums.length];
        int a_index = 0;

        while (left >= 0 && right < nums.length) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                ans[a_index++] = nums[left]*nums[left];
                left--;
            } else {
                ans[a_index++] = nums[right]*nums[right];
                right++;
            }
        }

        while (left >= 0) {
            ans[a_index++] = nums[left]*nums[left];
            left--;
        }

        while (right < nums.length) {
            ans[a_index++] = nums[right]*nums[right];
            right++;
        }

        return ans;
    }

    public int[] sortedSquares03(int[] nums) {

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int[] sortedSquares04(int[] nums) {
        int left = 0, right = nums.length-1;
        int ans[] = new int[nums.length];
        int a_index = right;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right]*nums[right]) {
                ans[a_index] = nums[right]*nums[right];
                right--;
            } else {
                ans[a_index] = nums[left] * nums[left];
                left++;
            }
            a_index--;
        }
        return ans;
    }


    public static void main(String[] args) {
        int []nums = {-9, -2,-1,0};
        int[] result = sortedSquares(nums);

        for (int i : result) {
            System.out.println(i);
        }

    }


}
