package monotonic_stack;


import java.util.ArrayDeque;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; ++i) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]) {
                int index = deque.pollLast();
                ans[index] = i - index;
            }
            deque.addLast(i);
        }
        return ans;
    }
}
