package uf;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题
 *
 *
 * nums = [100,4,200,1,3,2]
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 */
public class LongestConsecutive_128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        UF uf = new UF(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) continue;
            map.put(nums[i], i);
            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
        }

        return uf.longestConsecutive();
    }

    class UF {
        int[] parent;
        int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int q, int p) {
            int pq = find(q);
            int pp = find(p);
            if (pq == pp) return;
            parent[pq] = pp;
            size[pp] += size[pq];
        }

        public int longestConsecutive() {
            int ans = 1;
            for (int i = 0; i < size.length; ++i) {
                int con = size[find(i)];
                ans = Math.max(ans, con);
            }
            return ans;
        }
    }

}
