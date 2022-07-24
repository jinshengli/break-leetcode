package weeken.w303;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 6127. 优质数对的数目
 * 给你一个下标从 0 开始的正整数数组 nums 和一个正整数 k 。
 *
 * 如果满足下述条件，则数对 (num1, num2) 是 优质数对 ：
 *
 * num1 和 num2 都 在数组 nums 中存在。
 * num1 OR num2 和 num1 AND num2 的二进制表示中值为 1 的位数之和大于等于 k ，其中 OR 是按位 或 操作，而 AND 是按位 与 操作。
 * 返回 不同 优质数对的数目。
 *
 * 如果 a != c 或者 b != d ，则认为 (a, b) 和 (c, d) 是不同的两个数对。例如，(1, 2) 和 (2, 1) 不同。
 *
 * 注意：如果 num1 在数组中至少出现 一次 ，则满足 num1 == num2 的数对 (num1, num2) 也可以是优质数对。
 *
 *
 *
 *
 */
public class CountExcellentPairs_6127 {

    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> visSet = new HashSet<>();
        HashMap<Integer, Integer> bitCntMap = new HashMap<>();
        for (int num : nums) {
            if (!visSet.contains(num)) {
                visSet.add(num);
                int cnt = Integer.bitCount(num);
                bitCntMap.put(cnt, bitCntMap.getOrDefault(cnt, 0) + 1);
            }
        }

        long ans = 0;
        for (Map.Entry<Integer, Integer> entryX : bitCntMap.entrySet()) {
            for (Map.Entry<Integer, Integer> entryY : bitCntMap.entrySet()) {
                if (entryX.getKey() + entryY.getKey() >= k) {
                    ans += (long) entryX.getValue() * entryY.getValue();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer integer = new Integer(2);

        System.out.println(Integer.bitCount(7));
        System.out.println(Integer.lowestOneBit(4));
        System.out.println(Integer.highestOneBit(7));
    }

}
