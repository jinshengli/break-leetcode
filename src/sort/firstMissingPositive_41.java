package sort;


import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 1 <= nums.length <= 5 * 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class firstMissingPositive_41 {


    // k ---> index = k - 1
    // 1 --- n
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        firstMissingPositive_41 test = new firstMissingPositive_41();
        int[] nums = {3,4,-1,1};
        test.firstMissingPositive(nums);
    }


    public int firstMissingPositive002(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (binarySearch(nums, i) > 0) {
                return i;
            }
        }
        return n + 1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public int firstMissingPositive01(int[] nums) {
        int n = nums.length;
        int[] bucket = new int[n+1];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0 && nums[i] <= n) {
                bucket[nums[i]]++;
            }
        }
        for (int i = 1; i < bucket.length; ++i) {
            if (bucket[i] == 0) {
                return i;
            }
        }
        return n + 1;
    }

}
