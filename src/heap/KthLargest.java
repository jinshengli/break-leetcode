package heap;



import java.util.PriorityQueue;

/**
 * create by ljs on 2020/7/20 20:17
 * description:     703. 数据流中的第K大元素
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class KthLargest {

    private PriorityQueue<Integer> q;
    private int limit;

    public KthLargest(int k, int[] nums) {
        limit = k;
        q = new PriorityQueue<>(limit);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        if (q.size() < this.limit ) {
            q.offer(val);
            // limit++; 卧槽，坑呀。
        }
        else if ( q.peek() < val ) {
                q.poll();
                q.offer(val);
        }
        return q.peek();
    }




    public static void main(String[] args) {

        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3); // returns 4
        kthLargest.add(5); // returns 5
        kthLargest.add(10); // returns 5
        kthLargest.add(9); // returns 8
        kthLargest.add(4); // returns 8



    }


}
