package weeken.dw83;


import java.util.HashSet;

/**
 * 6131. 不可能得到的最短骰子序列
 *
 *
 * 给你一个长度为 n 的整数数组 rolls 和一个整数 k 。你扔一个 k 面的骰子 n 次，骰子的每个面分别是 1 到 k ，其中第 i 次扔得到的数字是 rolls[i] 。
 *
 * 请你返回 无法 从 rolls 中得到的 最短 骰子子序列的长度。
 *
 * 扔一个 k 面的骰子 len 次得到的是一个长度为 len 的 骰子子序列 。
 *
 * 注意 ，子序列只需要保持在原数组中的顺序，不需要连续。
 *
 * n == rolls.length
 * 1 <= n <= 10^5
 * 1 <= rolls[i] <= k <= 10^5
 */
public class ShortestSequence_6131 {

    public int shortestSequence(int[] rolls, int k) {
        HashSet<Integer> cnt = new HashSet<>();
        int ans = 1;
        for (int roll : rolls) {
            cnt.add(roll);
            if (cnt.size() == k) {
                ans++;
                cnt.clear();
            }
        }
        return ans;
    }
}
