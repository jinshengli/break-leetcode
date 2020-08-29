package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *  剑指 Offer 59 - II. 队列的最大值
 *
 *  https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 *  请定义一个队列并实现函数 max_value 得到队列里的最大值，
 *  要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 *  需要维护一个队列；queue
 *
 *  维护一个单调队列；保存这个队列中的最大值。 deque
 *
 *
 *  // todo 注意： 包装类型之间的比较， 不能用 == 啊；
 */

public class MaxQueue_59II {

    private Queue<Integer> queue = null;
    private Deque<Integer> deque = null;

    public MaxQueue_59II() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if ( deque.isEmpty() )
            return -1;
        return deque.getFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while ( !deque.isEmpty() && deque.peekLast() < value ) {
            deque.removeLast();  // 这时来个一个更大的；需要抛弃比它小的数。
        }
        //deque.add(value);
        deque.addLast(value);
    }

    public int pop_front() {
        if ( queue.isEmpty() )
            return -1;
        Integer poll = queue.poll(); // 这个是对象一定要注意了 大bug
        //if ( poll == deque.getFirst() )
        if ( poll.equals(deque.getFirst()) )
            deque.removeFirst();
        return poll;
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        while (!deque.isEmpty()) {
            Integer integer = deque.removeFirst();
            System.out.println(integer);

        }
    }

}
