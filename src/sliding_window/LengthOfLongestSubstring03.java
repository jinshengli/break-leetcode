package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * create by ljs on 2020/7/22 11:45
 * description:
 *
 *  请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 */
public class LengthOfLongestSubstring03 {

    public int lengthOfLongestSubstring(String s) {

        if ( s == null || s == "" || s.length() == 1 )
            return 1;

        int ans = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for ( int i = 0; i < chars.length-1; ++i ) {
            set.add(chars[i]);
            for ( int j = i + 1; j < chars.length; ++j ) {
                if ( set.contains(chars[j]) ) {
                    // ans = Math.max(ans, set.size());
                    break;
                } else {
                    set.add(chars[j]);
                }
            }
            ans = Math.max(ans, set.size());
            set.clear();
        }
        return ans;
    }


    /**
     *  类似滑动窗口的，双指针的算法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring01(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int left = 0, right = 0;
        int ans = 0;
        // 字符对应的下标位置
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }



}
