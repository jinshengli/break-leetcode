package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * create by ljs on 2020/7/26 8:38
 * description:
 *
 *      378. 有序矩阵中第K小的元素
 *
 *
 *      给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 *  你可以假设 k 的值永远是有效的，1 ≤ k ≤ n^2 。
 */
public class KthSmallest_378 {

    /**
     *      选出第一列中最小的，
     *          哪一行的第一个被选出来了，然后往后选一个元素。
     *
     *      最小堆保存的数组  {matrix[x][y], x, y};
     *
     *          按照matrix[x][y]来排序。
     *
     * @param matrix
     * @param k
     * @return
     */


    public int kthSmallest(int[][] matrix, int k) {

        int len = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 将第一列元素入； 同时加入它的坐标
        for ( int i = 0; i < len; ++i ) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        for ( int i = 0; i < k-1; ++i ) {

            int[] node = pq.poll(); //

            if ( node[2] != len-1 ) {
                pq.offer(new int[]{matrix[node[1]][node[2]+1], node[1], node[2]+1}); // 选择该某行的下一个元素。
            }

        }

        return pq.poll()[0];
    }


}
