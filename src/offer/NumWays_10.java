package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  题目 案例有点傻逼； 不计较好吧，一个意思。
 *
 */

public class NumWays_10 {

    //
    public int numWays(int n) {
        if (n < 0)
            return -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        clime(n, map);
        return map.get(n);
    }
    private int clime(int n, Map<Integer, Integer> map) {
        if ( n <= 1 )
            return map.get(n);
        if ( map.get(n) != null )
            return map.get(n);
        int ans = (clime(n-1,map)%1000000007 + clime(n-2,map)%1000000007)%1000000007;
        map.put(n,ans);
        return ans;
    }

    public static void main(String[] args) {
        NumWays_10 numWays_10 = new NumWays_10();
        int i = numWays_10.numWays(7);
        System.out.println(i);

    }

}


