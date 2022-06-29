package prefix_and;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 *
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法
 *
 */

public class MinSubArrayLen_209 {

    // target >= 1, nums 全大于0  滑动窗口
    public int minSubArrayLen01(int target, int[] nums) {
        int sum = 0;
        int ans = nums.length + 1;
        for (int i = 0, j = 0; j < nums.length; ++j) {
            sum += nums[j];
            while (sum - nums[i] >= target) {
                sum -= nums[i++];
            }

            if (sum >= target) {
                ans = Math.min(ans, j - i + 1);
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }


    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for (int i = 1; i <= n; ++i) {
            int targetSum = sum[i - 1] + target;  // i - 1
            int index = binarySearch(sum, i, n, targetSum);
            if (index != -1) {
                ans = Math.min(ans, index - i + 1);
            }
        }
        return ans == n + 1 ? 0 : ans;
    }

    private int binarySearch(int[] sums, int left, int right, int targetSum) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (sums[mid] >= targetSum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return sums[left] >= targetSum ? left : -1;
    }

    public static void main(String[] args) {
        MinSubArrayLen_209 minSubArrayLen_209 = new MinSubArrayLen_209();
        int target = 7;
        int []nums = {2,3,1,2,4,3};
        int i = minSubArrayLen_209.minSubArrayLen(target, nums);

        System.out.println(i);
    }

}
