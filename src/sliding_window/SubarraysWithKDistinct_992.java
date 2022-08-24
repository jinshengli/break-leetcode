package sliding_window;


/**
 * 992. K 个不同整数的子数组
 * 给定一个正整数数组 nums和一个整数 k ，返回 num 中 「好子数组」 的数目。
 *
 * 如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
 *
 * 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
 * 子数组 是数组的 连续 部分。
 *
 *
 *
 *
 1 <= nums.length <= 2 * 10^4
 1 <= nums[i], k <= nums.length


 */
public class SubarraysWithKDistinct_992 {

    /**
     * 将问题转化。
     *      刚好由k个不同整数组成的子数组个数 = 最多由k个不同字符组成的子数字个数 - 最多由k - 1个不同字符的子数组个数
     * @param nums
     * @param k
     * @return
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k-1);
    }

    private int atMostKDistinct(int[] nums, int k) {
        int left = 0; int right = 0;
        int n = nums.length;
        int[] freq = new int[n + 1];
        int distinct = 0;
        int res = 0;
        while (right < nums.length) {
            if (freq[nums[right]] == 0) {
                distinct++;
            }
            freq[nums[right]]++;
            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }


}
