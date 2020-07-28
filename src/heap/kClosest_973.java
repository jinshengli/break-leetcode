package heap;

import java.util.PriorityQueue;

/**
 * create by ljs on 2020/7/26 9:39
 * description:
 *      973. 最接近原点的 K 个点
 *
 *     最大堆。
 *
 *     输入：points = [[1,3],[-2,2]], K = 1
 *
 *      输出：[[-2,2]]
 *
 *      1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class kClosest_973 {


    public int[][] kClosest(int[][] points, int K) {


        int len = points.length;
        int[][] result = new int[K][2];

        if ( K >= len ) {
            return points;
        }

        //  {x,y}
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(((o1, o2) -> o2[0]*o2[0] + o2[1]*o2[1] - o1[0]*o1[0] - o1[1]*o1[1]));

        for ( int i = 0; i < len; ++i ) {

            maxHeap.add(new int[]{points[i][0], points[i][1]});
            if ( maxHeap.size() > K ) { // 每次剔除最大值
                maxHeap.poll();
            }

        }

        for (int i = 0; i < K; ++i ) {
            int[] poll = maxHeap.poll();
            result[i][0] = poll[0];
            result[i][1] = poll[1];
        }

        return result;
    }

}

