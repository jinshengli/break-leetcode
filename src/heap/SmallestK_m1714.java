package heap;

import java.util.PriorityQueue;

/**
 * create by ljs on 2020/7/26 10:07
 * description:
 *
 *      设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 *      0 <= len(arr) <= 100000
 *      0 <= k <= min(100000, len(arr))
 *
 */
public class SmallestK_m1714 {

    public int[] smallestK(int[] arr, int k) {

        if ( arr.length == 0 || k == 0 )
            return new int[0];

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(((o1, o2) -> o2-o1));
        int[] result = new int[k];
        for ( int i = 0; i < arr.length; ++i ) {
            pq.offer(arr[i]);
            if ( pq.size() > k )
                pq.poll();
        }

        for ( int i = 0; i < k; ++i ) {
            result[i] = pq.poll();
        }
        return result;
    }


}
