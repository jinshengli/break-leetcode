package offer;


/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 *  输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 *  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *
 *
 */

public class reverseLeftWords_582 {

    /**
     *  切片的做法
     *  s[n:s.length()) + s[0,n)
     *
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0,n);
    }

    /**
     *    通过遍历字符串 来实现。、
     *
     *    StringBuilder
     *          先遍历后面 [n:-1]
     *          再遍历前面 [0,n)
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords01(String s, int n) {

        if ( s == null || s.length() == 0 )
            return s;

        StringBuilder result = new StringBuilder();
        for ( int i = n; i < s.length(); ++i ) {
            result.append(s.charAt(i));
        }

        for ( int i = 0; i < n; ++i ) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
