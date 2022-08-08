package recursion;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 * 特殊的二进制序列是具有以下两个性质的二进制序列：
 *
 * 0 的数量与 1 的数量相等。
 * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
 * 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。
 *
 *
 * （两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
 *
 * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
 *
 *
 * 761. 特殊的二进制序列
 * 特殊的二进制序列是具有以下两个性质的二进制序列：
 *
 * 0 的数量与 1 的数量相等。
 * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
 * 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。
 * （两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
 *
 * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
 *
 * S 的长度不超过 50。
 * S 保证为一个满足上述定义的特殊 的二进制序列。
 *
 */
public class MakeLargestSpecial_761 {


    public static String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        List<String> list = new ArrayList<>();
        int left = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                String tmp = "1" + makeLargestSpecial(s.substring(left + 1, i)) + "0";
                list.add(tmp);
                left = i + 1;
            }
        }
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        list.stream().forEach(e -> sb.append(e));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000"));
    }

}
