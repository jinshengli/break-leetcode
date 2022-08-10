package offer2;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer II 038. 每日温度
 * 请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 */
public class oo38_dailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; ++i) {
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]) {
                int top = deque.pollLast();
                ans[top] = i - top;
            }
            deque.addLast(i);
        }
        return ans;
    }
}
