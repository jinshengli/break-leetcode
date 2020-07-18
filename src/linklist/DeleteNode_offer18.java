package linklist;

/**
 * create by ljs on 2020/7/11 8:17
 * description:
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
                    pre = cur.next;
                    head = pre;
                } else {    // 删除其它位置的一个节点
                    pre.next = cur.next;
                }
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
