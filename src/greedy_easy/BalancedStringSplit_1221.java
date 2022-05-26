package greedy_easy;


/**
 *
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
 *
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 *
 */
public class BalancedStringSplit_1221 {

    public static int balancedStringSplit(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int ans = 0;
        int balanceCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (chars[i] == 'L') {
                balanceCount++;
            } else {
                balanceCount--;
            }
            if (balanceCount == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }


}
