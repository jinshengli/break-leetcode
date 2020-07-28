package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * create by ljs on 2020/7/25 20:56
 * description:
 *
 *  剑指 Offer 40. 最小的k个数
 */
public class GetLeastNumbers_40 {


    /**
     *     最大堆。 维护k个元素的最大堆，【这个将是数组中的最小的k个元素】
     *             遍历一个元素 x; 它如果比 堆顶元素还要小，堆顶出堆，x进堆。
     * @param arr
     * @param k   // todo 了解一个lamda表达式
     * @return
     */

    public int[] getLeastNumbers(int[] arr, int k) {


        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        Queue<Integer> heap = new PriorityQueue<>( (v1, v2)-> v2-v1 );
        for ( int i = 0; i < arr.length; ++i ) {
            if ( i < k ) {
                heap.offer(arr[i]);
            } else if ( heap.peek() > arr[i] ) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        int index = 0;
        while ( !heap.isEmpty() ) {
            result[index++] = heap.poll();
        }
        return result;
    }

}
