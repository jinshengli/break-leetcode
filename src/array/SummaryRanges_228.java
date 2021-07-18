package array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @作者 ljs
 * @创建日期 2021/7/1 下午11:28
 *
 * 228. 汇总区间
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SummaryRanges_228 {

    /**
     * 双指针完成。
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for( int low = 0, high = 0; high < nums.length; ++high ) {
            if ( (high + 1) < nums.length  && nums[high]+1 == nums[high+1]) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nums[low]);
            if (low != high) {
                sb.append("->" + nums[high]);
            }
            result.add(sb.toString());
            low = high + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges_228 test = new SummaryRanges_228();
        int num[] = {1,2,3,4,6,9,10,13};
        List<String> list = test.summaryRanges(num);
        System.out.println(list);

    }


}
