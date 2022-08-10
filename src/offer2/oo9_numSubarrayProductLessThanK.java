package offer2;


/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 1 <= nums.length <= 3 * 10^4
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10^6
 */
public class oo9_numSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int mulResult = 1;
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            mulResult *= nums[right];
            while (mulResult >= k && left <= right) {
                mulResult = mulResult / nums[left++];
            }
            if (mulResult < k && left <= right) {
                ans += (right - left) + 1;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        oo9_numSubarrayProductLessThanK test = new oo9_numSubarrayProductLessThanK();
        int[] nums = {1,2,3};
        int k = 0;
        int i = test.numSubarrayProductLessThanK(nums, k);

    }
}
