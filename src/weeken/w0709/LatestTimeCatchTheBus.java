package weeken.w0709;


import java.util.Arrays;

/**
 *
 *
 * 6117. 坐上公交的最晚时间
 *
 * 给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。
 * 同时给你一个下标从 0 开始长度为 m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。
 *
 * 所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同。
 *
 * 给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。
 *
 * 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x  且公交没有满，那么你可以搭乘这一辆公交。最早 到达的乘客优先上车。
 *
 * 返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。
 *
 * 注意：数组 buses 和 passengers 不一定是有序的。
 *
 *
 *
 * 输入：buses = [10,20,30], passengers = [2,17,18,19], capacity = 2
 *
 * ：buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2
 *
 * 10, 20, 30
 *
 * 4, 11, 13, 19, 21, 25, 26
 *
 * n == buses.length
 * m == passengers.length
 * 1 <= n, m, capacity <= 105
 * 2 <= buses[i], passengers[i] <= 109
 * buses中的元素 互不相同。
 * passengers中的元素 互不相同
 *
 */


public class LatestTimeCatchTheBus {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int c = capacity;
        int ans = 0;
        int j = 0;
        for (int bus : buses) {
            for (c = capacity; j < passengers.length && c > 0 && passengers[j] <= bus; j++) {
                c--;
            }
        }
        j--;
        ans = c > 0 ? buses[buses.length-1] : passengers[j];
        while (j >= 0 && passengers[j] == ans) {
            j--;
            ans--;
        }
        return ans;
    }

}
