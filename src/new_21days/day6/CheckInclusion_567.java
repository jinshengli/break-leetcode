package new_21days.day6;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * @author ljs
 * @since 2021/7/24 下午4:32
 **/
public class CheckInclusion_567 {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int c1[] = new int[26];
        int c2[] = new int[26];
        for (int i = 0; i < n; ++i) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(c1,c2)) {
            return true;
        }

        for (int i = n; i < m; ++i) {
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i-n) - 'a']--;
            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }
        return false;
    }


}
