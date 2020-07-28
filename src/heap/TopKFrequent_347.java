package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * create by ljs on 2020/7/26 9:00
 * description:
 *
 *      347. 前 K 个高频元素
 *
 *      给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *      输入: nums = [1,1,1,2,2,3], k = 2
 *      输出: [1,2]
 *
 *     使用k最小堆，
 */
public class TopKFrequent_347 {


    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for ( int i = 0; i < nums.length; ++i ) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {  // 这里不需要比较了。
           pq.offer(entry);
           if ( pq.size() > k )
               pq.poll();
        }

        int index = k-1;
        while (!pq.isEmpty()) {
            result[index--] = pq.poll().getKey();
        }

        return result;

    }

}
