package weeken.w0709;

import java.util.Arrays;

public class MinSumSquareDiff {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int dp[] = new int[nums1.length];

        for (int i = 0; i < dp.length; ++i) {
            dp[i] = Math.abs(nums1[i] - nums2[i]);
        }
        Arrays.sort(dp);
        int time = Math.max(dp.length, k1 + k2);

        if (time == 0 || dp[dp.length - 1] == 0) {

        }
        return 0;
        
    }

}
