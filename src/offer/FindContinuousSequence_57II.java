package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 *
 *  输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 *  序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 
 */

public class FindContinuousSequence_57II {

    //  todo 使用滑动窗口解决问题

    /**
     *  [i,j) 范围内的和。
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {

        int i = 1, j = 1;
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        while ( i <= target/2 ) {

            if ( sum < target ) {
                // 扩大滑动窗口
                sum = sum + j;
                j++;
            } else if (sum > target ){
                // 缩小滑动窗口
                sum = sum - i;
                i++;
            } else if ( sum == target ){
                // 获取结果
                int[] ans = new int[j-i];
                for ( int k = i; k < j; ++k )
                    ans[k-i] = k;
                result.add(ans);
                // 同时向右滑动一个。
                sum -= i;
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
