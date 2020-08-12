package dynamic_programming;

/**
 * create by ljs on 2020/8/12 15:14
 * description:
 *
 *      72. 编辑距离
 *
 *      给你两个单词 word1 和 word2，
 *      请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 *      dp[i][j] 表示 以下标i结尾的字符串 转成 以下标 j 结尾的字符串使用的最小操作。： 不合适
 *
 *      dp[i][j] 字符串 w1  前 i个字符结尾的字串 转成 字符串w2 前j个字符结尾的字串 的最小操作。
 *
 *      dp[i][j] =  min (
 *
 *          dp[i-1][j-1] + 1; if w1[i] != w2[j] 或者 执行 w1[i] 替换成 w2[j]
 *          dp[i-1][j] + 1;  // 执行 删除 w1[i] 字符。
 *          dp[i][j-1] + 1;  // 执行在 w1[i] 字符后面添加一个 字符 w2[j]。
 *      )
 *
 *
 *      dp[i-1][j-1] ===> 肯定是比 dp[i][j-1] + 1 ; dp[i-1][j] + 1 小。
 *
 */
public class MinDistance_72 {


    // 有错误。  base 初始化不好定义

    public int minDistance(String word1, String word2) {


        if ( word1 == null || word1.length() == 0 ) {
            return word2.length();
        }

        if ( word2 == null || word2.length() == 0 ) {
            return word1.length();
        }


        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1][l2];

        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0:1; // 这个初始化定义不合适。 a : aaaaaa
        for ( int j = 1; j < l2; ++j ) {  // eat --> aet :

            dp[0][j] = word1.charAt(0) == word2.charAt(j) ? dp[0][j-1] : dp[0][j-1] + 1;
        }

        for ( int i = 1; i < l1; ++i ) {
            dp[i][0] = word1.charAt(i) == word2.charAt(0) ? dp[i-1][0] : dp[i-1][0] + 1;
        }


        for ( int i = 1; i < l1; ++i ) {
            for ( int j = 1; j < l2; ++j ) {
                int min = Integer.MAX_VALUE;
                if ( word1.charAt(i) == word2.charAt(j) ) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    min = Math.min(min, dp[i-1][j-1] + 1);
                    min = Math.min(min, dp[i-1][j] + 1);
                    min = Math.min(min, dp[i][j-1] + 1);
                    dp[i][j] = min;
                }

            }

        }

        return dp[l1-1][l2-1];

    }

    // 改变边界问题； 针对特殊 情况  "" ----> "abcd";   "addd" ---> ""
    public int minDistance01(String word1, String word2) {


        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        dp[0][0] = 0;
        for ( int j = 1; j <= l2; ++j ) {  // 代表 "" -->  a1a2a2 需要的操作步数
            dp[0][j] = dp[0][j-1] + 1;
        }

        for ( int i = 1; i <= l1; ++i ) {  // "abcdef" ---> ""
            dp[i][0] = dp[i-1][0] + 1;
        }

        int min;
        for ( int i = 1; i <= l1; ++i ) {
            for ( int j = 1; j <= l2; ++j ) {
                if ( word1.charAt(i-1) == word2.charAt(j-1) ) {
                    dp[i][j] = dp[i-1][j-1];  // 这个
                } else {
                    min = Integer.MAX_VALUE;
                    min = Math.min(min, dp[i-1][j-1] + 1);
                    min = Math.min(min, dp[i-1][j] + 1);
                    min = Math.min(min, dp[i][j-1] + 1);
                    dp[i][j] = min;
                }

            }

        }

        return dp[l1][l2];

    }


    //  代码优化、
    public int minDistance02(String word1, String word2) {


        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        dp[0][0] = 0;

        if ( l1 * l2 == 0 ) { // 哪怕哪个为空。
            return l1 + l2;
        }


        for ( int j = 1; j <= l2; ++j ) {  // 代表 "" -->  a1a2a2 需要的操作步数
            dp[0][j] = dp[0][j-1] + 1;
        }

        for ( int i = 1; i <= l1; ++i ) {  // "abcdef" ---> ""
            dp[i][0] = dp[i-1][0] + 1;
        }

        for ( int i = 1; i <= l1; ++i ) {
            for ( int j = 1; j <= l2; ++j ) {
                if ( word1.charAt(i-1) == word2.charAt(j-1) ) {
                    dp[i][j] = dp[i-1][j-1];  // 这个
                } else {

                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }

            }

        }

        return dp[l1][l2];

    }


    public static void main(String[] args) {

        int i = new MinDistance_72().minDistance("a", "aaaaaaa");
        System.out.println(i);

    }


}
