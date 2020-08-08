package dynamic_programming;

/**
 * create by ljs on 2020/8/3 22:23
 * description:
 *
 *
 *  1143. 最长公共子序列
 *
 *  dp[i][j];  字符串 i 结尾； 或者 字符串 j 结尾；它们之间的公共子序列
 *
 *  c1[i] == c2[j]---> dp[i][j] = dp[i-1][j-1] + 1;
 *  c1[i] != c2[j] ---> dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 *
 */
public class LongestCommonSubsequence_1143 {


    public int longestCommonSubsequence(String text1, String text2) {

        if ( text1 == null || text2 == null )
            return 0;

        int len1 = text1.length(), len2 = text2.length();
        if ( len1 == 0 || len2 == 0 )
            return 0;

        int[][] dp = new int[len1+1][len2+1];

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();

        for ( int i = 0; i < len1; ++i ) {
            for ( int j = 0; j < len2; ++j ) {
                if ( c1[i] == c2[j] ) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[len1][len2];
    }


}
