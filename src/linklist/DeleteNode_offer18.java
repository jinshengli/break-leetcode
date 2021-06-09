package linklist;

/**
 * create by ljs on 2020/7/11 8:17
 * description:
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 *
 *  1. 要删除的节点在第一个位置
 *
 *  head = head.next
 *  // pre = pre.next
 *
 *  2. 中间的一个
 *  pre.next = pre.next.next
 *
 *  3. 链表末尾 一个
 *  pre.next = null
 *
 *
 *  2;3的情况删除一样。
 *
 *
 */
public class DeleteNode_offer18 {


    public ListNode deleteNode(ListNode head, int val) {

        ListNode pre = null;
        ListNode cur = head;
        while ( cur != null ) {
            if ( cur.val == val ) {
                if ( pre == null ) { // 删除第一个节点
                    cur = cur.next;
                    head = cur;
                } else {    // 删除其它位置的一个节点
                    pre.next = cur.next;
                    cur = cur.next;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     *  就删除一个val值的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode01(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }

}
