package linklist;


/**
 *
 * 641. 设计循环双端队列
 *
 * 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k)：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true，否则返回 false 。
 * boolean insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true，否则返回 false 。
 * boolean deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true，否则返回 false 。
 * boolean deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true，否则返回 false 。
 * int getFront())：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * int getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1 。
 * boolean isEmpty()：若双端队列为空，则返回true，否则返回 false 。
 * boolean isFull()：若双端队列满了，则返回true，否则返回 false 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class MyCircularDeque_641 {
    int size;
    int cap;
    ListNode head;
    ListNode tail;

    public MyCircularDeque_641(int k) {
        this.cap = k;
        this.size = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.pre = head;
    }

    // 将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        ListNode cur = new ListNode(value);
        ListNode oldFirst = head.next;
        cur.next = oldFirst;
        oldFirst.pre = cur;
        head.next = cur;
        cur.pre = head;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        ListNode cur = new ListNode(value);
        ListNode oldEnd = tail.pre;
        oldEnd.next = cur;
        cur.pre = oldEnd;
        cur.next = tail;
        tail.pre = cur;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        ListNode firstNode = head.next;
        head.next = firstNode.next;
        firstNode.next.pre = head;
        firstNode.next = null;
        firstNode.pre = null;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        ListNode lastNode = tail.pre;
        lastNode.pre.next = tail;
        tail.pre = lastNode.pre;
        lastNode.pre = null;
        lastNode.next = null;
        size--;
        return true;
    }

    public int getFront() {
        return head.next.val;
    }

    public int getRear() {
        return tail.pre.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

// ["MyCircularDeque","insertFront","insertLast","getFront","insertLast","getFront",
// "insertFront","getRear","getFront","getFront","deleteLast","getRear"]
//[[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]

// 3, 7, 0

// 7, 7, 0, 3,

