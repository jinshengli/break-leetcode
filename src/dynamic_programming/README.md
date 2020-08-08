
#### 动态规划专题


动态规划和递归或者分治没有根本上的区别（关键看有无最优子结构）
拥有共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解。

-----------

最优子结构
找到重复子问题
差异性：最优子结构，中途可以淘汰次优解

分治 + 最优子结构

顺推: 动态递推。





1. 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2], ...)

2. 存储中间状态： opt[i]

3. 状态转移方程



#### 股票买卖题目

dp[i][k][0 or 1] (0 <= i <= n-1, i < k <= K )

i 为天数
k 为最多交易次数
[0,1] 为是否持有股票

总状态数：n*K*2种状态


for 0 <= i < n:
    for 1 <= k <= K:
        for s in {0,1}:
            dp[i][k][s] = max(buy,sell,rest)
            

dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
              max(  选择 reset, 选择sell )
              
解析：今天我没有持有股票，有两种可能：
- 我昨天就没有持有股票，然后今天选择rest, 所以我今天还没有持有；
- 我昨天持有股票，但是我今天我sell, 所以我今天没有股票了

dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i] )
              max(  选择reset,        选择buy )

解析： 今天我持有着股票，有两种可能：

-我昨天就持有股票，然后今天选择rest, 所以我今天还持有着股票；
-我昨天没有持有，但今天我选择buy, 所以今天我就持有股票了。


              

f[n] = f[n-i*i] + 1
i = ( 0 .. i ) in i*i <= n






    

#### 题目
    
62. 不同路径
    
https://leetcode-cn.com/problems/unique-paths/

63. 不同路径 II
https://leetcode-cn.com/problems/unique-paths-ii/


1143. 最长公共子序列

https://leetcode-cn.com/problems/longest-common-subsequence/



剑指 Offer 42. 连续子数组的最大和
https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/


392. 判断子序列
https://leetcode-cn.com/problems/is-subsequence/



NumArray
303. 区域和检索 - 数组不可变
https://leetcode-cn.com/problems/range-sum-query-immutable/


746. 使用最小花费爬楼梯
https://leetcode-cn.com/problems/min-cost-climbing-stairs/


面试题 17.16. 按摩师
和 打家劫舍的题目一样。  不能连续的工作
https://leetcode-cn.com/problems/the-masseuse-lcci/


121. 买卖股票的最佳时机
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/


122. 买卖股票的最佳时机 II
https://leetcode-cn.com/problems/house-robber-ii/description/


123. 买卖股票的最佳时机 III
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/


279. 完全平方数
    类似爬楼梯
https://leetcode-cn.com/problems/perfect-squares/


实战题目
•	https://leetcode-cn.com/problems/house-robber/
•	https://leetcode-cn.com/problems/house-robber-ii/description/
•	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
•	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
•	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
•	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
•	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
•	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
•	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
高级 DP 实战题目
•	https://leetcode-cn.com/problems/perfect-squares/
•	https://leetcode-cn.com/problems/edit-distance/ （重点）
•	https://leetcode-cn.com/problems/jump-game/
•	https://leetcode-cn.com/problems/jump-game-ii/
•	https://leetcode-cn.com/problems/unique-paths/
•	https://leetcode-cn.com/problems/unique-paths-ii/
•	https://leetcode-cn.com/problems/unique-paths-iii/
•	https://leetcode-cn.com/problems/coin-change/
•	https://leetcode-cn.com/problems/coin-change-2/
注意：请大家先消化前面的实战题目，高级 DP 的方法和题解会在课程后面解锁。
课后作业
•	https://leetcode-cn.com/problems/longest-valid-parentheses/
•	https://leetcode-cn.com/problems/minimum-path-sum/
•	https://leetcode-cn.com/problems/edit-distance/
•	https://leetcode-cn.com/problems/decode-ways
•	https://leetcode-cn.com/problems/maximal-square/
•	https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
•	https://leetcode-cn.com/problems/frog-jump/
•	https://leetcode-cn.com/problems/split-array-largest-sum
•	https://leetcode-cn.com/problems/student-attendance-record-ii/
•	https://leetcode-cn.com/problems/task-scheduler/
•	https://leetcode-cn.com/problems/palindromic-substrings/
•	https://leetcode-cn.com/problems/minimum-window-substring/
•	https://leetcode-cn.com/problems/burst-balloons/












    