package sliding_window;

public class Template {


    /**
     * 1.1 最长子数组长度
     * 我们先求一个简单问题：求 A 中最多由 K 个不同整数组成的最长子数组的长度。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findLongestArrWithKNum(int[] nums, int k) {
        int left = 0; int right = 0;
        int[] freq = new int[1010];
        int count = 0;
        int ans = 0;
        while (right < nums.length) {
            if (freq[nums[right]] == 0) {
                count++;
            }
            freq[nums[right]]++;
            while (count > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    /**
     * 问 A 中由最多 K 个不同整数组成的子数组的个数
     * ans += right - left + 1
     */
}
