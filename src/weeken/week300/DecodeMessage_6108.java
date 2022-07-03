package weeken.week300;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 *
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，
 * 可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 *
 *
 * 26 <= key.length <= 2000
 * key 由小写英文字母及 ' ' 组成
 * key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
 * 1 <= message.length <= 2000
 * message 由小写英文字母和 ' ' 组成
 *
 */
public class DecodeMessage_6108 {

    // 解密
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        int index = 0;
        for (char c : key.toCharArray()) {
            if (map.containsKey(c) || c == ' ') {
                continue;
            }
            map.put(c, (char) (index + 'a'));
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append(map.get(c));
            }
        }
        return sb.toString();
    }

    public String decodeMessage01(String key, String message) {
        int[] map = new int[26];
        int index = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : key.toCharArray()) {
            if (set.contains(c) || c == ' ') {
                continue;
            }
            set.add(c);
            map[index++] = c - 'a';
        }

        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
            } else {
                int value = map[c - 'a'];
                sb.append((char) (value + 'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeMessage_6108 decodeMessage_6108 = new DecodeMessage_6108();
        String ans = decodeMessage_6108.decodeMessage("the quick brown fox jumps over the lazy dog", "abcd");

        System.out.println(ans);
    }
}
