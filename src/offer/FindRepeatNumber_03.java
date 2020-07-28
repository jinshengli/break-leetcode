package offer;

import java.util.HashSet;

/**
 * create by ljs on 2020/7/27 20:42
 * description:
 *
 *  剑指 Offer 03. 数组中重复的数字
 *
 *  找出数组中重复的数字。
 *
 */
public class FindRepeatNumber_03 {


    public int findRepeatNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if ( set.contains(num) )
                return num;
            set.add(num);
        }

        return -1; // 不存在重复读的。

    }

}
