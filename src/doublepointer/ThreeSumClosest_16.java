package doublepointer;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class ThreeSumClosest_16 {


    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i != 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    ans = sum;
                }

                if (sum <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    /**
     *  change 01 ok
     */
    public int threeSumClosest02(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int closetSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; ++i) {
            if (i != 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closetSum)) {
                    closetSum = sum;
                }
                if (sum <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closetSum;
    }

    /**
     *    int []num = {1,1,-1,-1,3};
     *         int target = -1;
     *
     *         解题错误，出现溢出问题
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest01(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int closetSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (i != 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                System.out.println(Math.abs(target - closetSum));
                if (Math.abs(target - sum) < Math.abs(target - closetSum)) {   // Math.abs(target - closetSum) 出现溢出 Integer.MIN_VALUE
                    closetSum = sum;
                }
                if (sum <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closetSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest_16 threeSumClosest_16 = new ThreeSumClosest_16();
        int []num = {1,1,-1,-1,3};
        int target = -1;
        int i = threeSumClosest_16.threeSumClosest(num, target);

        System.out.println(i);
    }
}
