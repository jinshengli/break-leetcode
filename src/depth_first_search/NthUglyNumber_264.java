package depth_first_search;

/**
 * create by ljs on 2020/8/12 21:44
 * description:
 *
 * 264. 丑数 II
 *
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是质因数只包含 2, 3, 5 的正整数
 *
 *
 *  丑数是由另外的一个丑数 * 2, 或者 * 3 ， 或者 * 5
 *
 *  找到 第 n 个丑数，需要有序的丑数。
 *
 *  1 是丑数。
 * n 不超过1690。
 *
 *
 */
public class NthUglyNumber_264 {

        private int[] dp = new int[1690];

    public int nthUglyNumber(int n) {

        if ( n == 1 ) {
            return 1;
        }

        dp[0] = 1; // 第一个丑数是 1.

        int t2 = 0, t3 = 0, t5 = 0; // 三指针指向 对应可以再次 *i 的最大的丑数。

        for ( int i = 1; i < 1690; ++i ) {

            int nextUgly = Math.min(Math.min(dp[t2]*2, dp[t3]*3), dp[t5]*5);
            dp[i] = nextUgly;

            if ( nextUgly == dp[t2]*2 )
                t2++;
            if ( nextUgly == dp[t3]*3 )
                t3++;
            if ( nextUgly == dp[t5]*5 )
                t5++;
        }
        return dp[n-1];
    }


}
