package heap;

import java.net.Inet4Address;
import java.util.PriorityQueue;

/**
 * create by ljs on 2020/7/25 21:23
 * description:
 *
 *      1046. 最后一块石头的重量
 *
 *      两两抵消
 *
 *
 *
 *      1 <= stones.length <= 30
 *      1 <= stones[i] <= 1000
 *
 */
public class LastStoneWeight_1046 {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> heap =
                new PriorityQueue<>((v1,v2)->v2-v1);
        for ( int i = 0; i < stones.length; ++i ) {
            heap.offer(stones[i]);
        }

        while ( heap.size() >= 2 ) {
            Integer p1 = heap.poll();
            Integer p2 = heap.poll();
            int abs = Math.abs(p1 - p2);
            if ( abs != 0 )
                heap.offer(abs);
        }

        // return heap.poll(); 出现了空指针异常 2,2
        if ( heap.isEmpty() )
            return 0;
        return heap.poll();
    }


}
