package weeken.dw83;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。
 *
 * 子数组 是一个数组中一段连续非空元素组成的序列。
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class ZeroFilledSubarray_6129 {

    public long zeroFilledSubarray(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                int len = j - i;
                cnt.put(len, cnt.getOrDefault(len, 0) + 1);
                i = j - 1;
            }
        }

        long ans = 0;
        for (Integer len : cnt.keySet()) {
            ans += cnt.get(len) * getAns(len);
        }
        return ans;
    }

    public long getAns(int len) {
        if (len == 1) {
            return 1;
        }
        return len + getAns(len-1);
    }

    public static void main(String[] args) {
        ZeroFilledSubarray_6129 test = new ZeroFilledSubarray_6129();

        test.zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4});
        long ans = test.getAns(2);
        System.out.println(ans);
    }
}
