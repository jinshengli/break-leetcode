package offer2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？
 *
 * 请找出所有和为 0 且 不重复 的三元组。
 *
 *  0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 */
public class oo7_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j-1] == nums[j]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}
