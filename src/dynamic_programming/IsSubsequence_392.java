package dynamic_programming;

/**
 * create by ljs on 2020/8/7 14:45
 * description:
 *
 *  392. 判断子序列
 *
 *  给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 *
 *  示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 */
public class IsSubsequence_392 {


    // 双指针。
    public boolean isSubsequence(String s, String t) {

        if ( s == null || t == null )
            return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int i = chars.length -1;
        int j = chart.length - 1;

        while ( i >= 0 && j >= 0 ) {
            if ( chars[i] == chart[j] ) {
                i--;
            }
            j--;
        }
        return i < 0 ? true:false;

    }

    // 优化 双指针
    public boolean isSubsequence01(String s, String t) {

        if ( s == null || t == null || t.length() == 0)
            return false;
        if ( s.length() == 0 )
            return true;
        int indexS = 0, indexT = 0;
        while ( indexT < t.length() ) {
            if ( s.charAt(indexS) == t.charAt(indexT) ) {
                indexS++;
                if ( indexS == s.length() )
                    return true;
            }
            indexT++;
        }
        return false;
    }

}
