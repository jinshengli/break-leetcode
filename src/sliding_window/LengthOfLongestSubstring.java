package sliding_window;

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
public class LengthOfLongestSubstring {

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



    public int lengthOfLongestSubstring01(String s) {

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



}
