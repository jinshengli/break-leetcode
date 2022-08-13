package monotonic_stack;


import java.util.*;

/**
 *
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 请你以字符串形式返回这个最小的数字。
 *
 *
 * 示例 1 ：
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 */
public class RemoveKdigits_402 {

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int delCnt = 0;
        for (int i = 0; i < num.length(); ++i) {
            while (!deque.isEmpty() && num.charAt(i) < deque.peekLast() && delCnt < k) {
                Character c = deque.pollLast();
                delCnt++;
            }
            deque.addLast(num.charAt(i));
        }

        while (delCnt < k && !deque.isEmpty()) {
            deque.pollLast();
            delCnt++;
        }

        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString() == "" ? "0" : sb.toString();
    }
}
