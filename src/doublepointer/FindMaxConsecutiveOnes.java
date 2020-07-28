package doublepointer;

/**
 * create by ljs on 2020/7/22 10:53
 * description:
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class FindMaxConsecutiveOnes {


    public int findMaxConsecutiveOnes(int[] nums) {

        int ans = 0, count = 0;
        for ( int i  = 0, length = nums.length; i < length; ++i ) {
            if ( nums[i] == 1 ) {
                count ++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        return ans > count ? ans:count; // 如果全是1、或者最后一组1为最大结果。
    }

}
