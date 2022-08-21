package weeken.dw85;


/**
 * 6158. 字母移位 II 显示英文描述
 * 给你一个小写英文字母组成的字符串 s 和一个二维整数数组 shifts ，其中 shifts[i] = [starti, endi, directioni] 。
 * 对于每个 i ，将 s 中从下标 starti 到下标 endi （两者都包含）所有字符都进行移位运算，如果 directioni = 1 将字符向后移位，如果 directioni = 0 将字符向前移位。
 *
 * 将一个字符 向后 移位的意思是将这个字符用字母表中 下一个 字母替换（字母表视为环绕的，所以 'z' 变成 'a'）。类似的，
 * 将一个字符 向前 移位的意思是将这个字符用字母表中 前一个 字母替换（字母表是环绕的，所以 'a' 变成 'z' ）。
 *
 * 请你返回对 s 进行所有移位操作以后得到的最终字符串。
 *
 *  1 <= s.length, shifts.length <= 5 * 10^4
 * shifts[i].length == 3
 * 0 <= starti <= endi < s.length
 * 0 <= directioni <= 1
 * s 只包含小写英文字母。
 *
 */
public class shiftingLetters_6158 {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] sc = s.toCharArray();
        int[] diff = new int[sc.length];
        for (int i = 0; i < shifts.length; ++i) {
            int[] shift = shifts[i];
            int start = shift[0]; int end = shift[1]; int dir = shift[2] == 0 ? -1 : 1;
            diff[start] += dir;
            if (end + 1 < diff.length) {
                diff[end + 1] -= dir;
            }
        }

        for (int i = 1; i < sc.length; i++) {
            diff[i] += diff[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sc.length; ++i) {
            int c = sc[i] - 'a';
            c = ((c + diff[i]) % 26 + 26) % 26; // diff[i] 可能是负数。
            sb.append((char) (c + 'a'));
        }
        return sb.toString();
    }
}
