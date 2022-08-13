package monotonic_stack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 768. 最多能完成排序的块 II
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 *
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，
 * 使得连接的结果和按升序排序后的原数组相同。
 *
 * 我们最多能将数组分成多少块？
 *
 *
 * 输入: arr = [5,4,3,2,1]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
 *
 * 输入: arr = [2,1,3,4,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
 * 然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。
 *
 *
 * 1、关键词：排序块。
 * 2、第一个排序块的最大值 <= 第二个排序块的最大值。
 * 3、前一个排序块的最大值一定大于或等于后面所有排序块的值。
 *
 * 3、
 *  1) 怎么才能合并一个排序块?  新遍历到的一个值，小于当前的排序块的最大值（peek）。  peek > num
 *      可能这个num 不单影响这个排序块，还可能需要将当前的排序块合并到前面的排序块中。
 *
 *  2) 怎么才能才算一个新的排序块？ 遍历到一个新的值，当前排序块的最大值小于等于它。 贪心可以算一个新的排序块。
 *
 *
 *  [1,1,0,0,1]
 *
 *  [5,1,1,8,1,6,5,9,7,8]
 *
 *  [1,1,1,5,8] 2
 *
 */
public class MaxChunksToSorted_768 {

    public int maxChunksToSorted(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!deque.isEmpty() && deque.peekLast() > arr[i]) {
                int peek = deque.peekLast();
                while (!deque.isEmpty() && arr[i] < deque.peekLast()) {
                    deque.pollLast();
                }
                deque.addLast(peek);
            } else {
                deque.addLast(arr[i]);
            }
        }
        return deque.size();
    }

}
