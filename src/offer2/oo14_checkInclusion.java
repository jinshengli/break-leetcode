package offer2;


/**
 * 剑指 Offer II 014. 字符串中的变位词
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 * 1 <= s1.length, s2.length <= 10^4
 * s1 和 s2 仅包含小写字母
 *
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 1 <= s1.length, s2.length <= 10^4
 * s1 和 s2 仅包含小写字母
 */
public class oo14_checkInclusion {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() < s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < c1.length; ++i) {
            map1[c1[i] - 'a']++;
            map2[c2[i] - 'a']++;
        }
        if (checkMapSame(map1, map2)) {
            return true;
        }
        int left = 0;
        for (int i = c1.length; i < c2.length; ++i) {
            map2[c2[left] - 'a']--;
            map2[c2[i] - 'a']++;
            left++;
            if (checkMapSame(map1, map2)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkMapSame(int[] map1, int[] map2) {
        for (int i = 0; i < map1.length; ++i) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }

}
