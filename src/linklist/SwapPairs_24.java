package linklist;

/**
 * create by ljs on 2020/7/10 19:40
 * description:  两两交换链表中的节点
 *
 *  给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 *  你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  fast: head.next
 *  slow: head
 *
 *  tmp: fast.next
 *
 *  change:
 *
 *  fast.next = slow
 *  slow.next = tmp
 *
 *  fast = tmp.next
 *  slow = tmp
 *  tmp = fast.next
 *
 *
 */
public class SwapPairs_24 {


    /**
     *  递归解决。
     *
     *  思考：
     *     1. 完成当前层的任务
     *     2. 返回值
     *     3. 结束条件。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if ( head == null || head.next == null ) {
            return head;
        }

        // firstNode , secondNode

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // 交换
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;

    }

    /**
     *  迭代法；  麻蛋好难看
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {

        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode prevNode = dumy;  // firstNode 的前驱节点。

        while ( (head != null ) && (head.next != null) ) {

            // Nodes to be swapped
            ListNode firstNode = head;    // 交换的第一个节点、
            ListNode secondNode = head.next;  // 交换第二个节点。

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next;


        }

        return dumy.next;

    }




}
