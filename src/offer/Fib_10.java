package offer;

/**
 * create by ljs on 2020/7/28 19:10
 * description:
 *
 *  斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  0 <= n <= 100
 *
 *
 */
public class Fib_10 {


    public int fib(int n) {
        if ( n < 2 )
            return n;
        return fib(n-1) + fib(n-2);
    }

    // 递推
    public int fib01(int n) {
        if ( n < 2 )
            return n;
        int f0 = 0, f1 = 1;
        int f2 = f0 + f1;
        for ( int i = 2; i <=n; ++i ) {
            f2 = (f0 + f1)%1000000007;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    /**
     *  递归 + 记忆化
     * @param n
     * @return
     */
    public int fib02(int n) {

        int[] cache = new int[n+1];
        helper(n, cache);
        return cache[n];
    }

    private int helper(int n, int[] cache) {
        if ( n < 2 )
            return n;
        if ( cache[n] != 0 )
            return cache[n];
        cache[n] = (helper(n-1, cache) + helper(n-2, cache))%1000000007;
        return cache[n];
    }


    public static void main(String[] args) {
        int fib = new Fib_10().fib01(100);
        System.out.println(fib);
    }



}
