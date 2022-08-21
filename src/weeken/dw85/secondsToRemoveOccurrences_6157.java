package weeken.dw85;


/**
 * 给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。
 *
 * 请你返回完成这个过程所需要的秒数。
 *
 * s = "0110101"
 *
 *     "1011010"
 *
 *     1 <= s.length <= 1000
 *     s[i] 要么是 '0' ，要么是 '1' 。
 */

    //0110101
    //1011010
    //1101100
    //1110100
    //1111000

    // 01
public class secondsToRemoveOccurrences_6157 {
    public int secondsToRemoveOccurrences(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] sc = s.toCharArray();
        return dfs(sc);
    }

    private int dfs(char[] sc) {
        boolean flag = false;
        for (int i = 0; i < sc.length - 1; ++i) {
            if (sc[i] == '0' && sc[i + 1] == '1') {
                char tmp = sc[i]; sc[i] = sc[i+1]; sc[i+1] = tmp;
                i = i + 1;
                flag = true;
            }
        }
        if (!flag) {
            return 0;
        } else {
            return 1 + dfs(sc);
        }
    }
}
