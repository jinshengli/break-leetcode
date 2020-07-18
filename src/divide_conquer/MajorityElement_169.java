package divide_conquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * create by ljs on 2020/7/8 19:53
 * description:
 *
 *      计算给定数组中超过 n/2 次数的数
 *
 *  // TODO get 不到分治法的解法
 *
 *
 *  摩尔投票法； 同类力量集合，不要自相残杀；异类一命换一命。 最后肯定是 数量超过 n/2 的种族胜出、
 *
 *
 *
 */
public class MajorityElement_169 {


    public int majorityElement(int[] nums) {

        int result;
        result =  resole(nums);
        return result;

    }

    // 在 n/2 位置的一定是 最多数的位置
    private int resole(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     *  通过map记录每个数字出现的次数、
     * @param nums
     * @return
     */
    private int resole2(int[] nums) {

        Map<Integer, Integer> ans = new HashMap<>();

        for (int num : nums) {
            if ( ! ans.containsKey(num) ) {
                ans.put(num,1);
            } else {
                ans.put(num, ans.get(num) +1 );
            }
        }

        Map.Entry<Integer, Integer> majorityEntry = null;

        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            if ( majorityEntry == null || entry.getValue() > majorityEntry.getValue() ) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();

    }


}
