package map;


import java.util.Arrays;

/**
 * 532. 数组中的 k-diff 数对
 * 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 *
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 *
 * 1, 1, 3, 4, 5
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
 *
 *
 * 1 <= nums.length <= 10^4
 * -10^7 <= nums[i] <= 10^7
 * 0 <= k <= 10^7
 *
 */
public class FindPairs_532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int y = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int target = k + nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }


    public int findPairs01(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] ==  nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; ++j) {
                if (Math.abs(nums[j] - nums[i]) == Math.abs(k)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }


}
