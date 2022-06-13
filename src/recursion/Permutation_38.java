package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * */
public class Permutation_38 {
    public String[] permutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(chars, 0, sb, ans);
        String[] strings = ans.toArray(new String[ans.size()]);
        return strings;
    }

    private void helper(char[] chars, int start, StringBuilder sb, List<String> ans) {
        if (sb.length() >= chars.length) {
            ans.add(sb.toString());
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < chars.length; ++i) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
//            if (i > start && chars[i-1] == chars[i]) {
//                continue;  // 失败的去重
//            }
            swap(chars, start, i);
            sb.append(chars[start]);
            helper(chars, start + 1, sb, ans);
            swap(chars, start, i);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        Permutation_38 permutation_38 = new Permutation_38();
        String[] abcs = permutation_38.permutation("suvyls");
        for (String s : abcs) {
            System.out.println(s);
        }
    }

}
