package linklist;

/**
 * create by ljs on 2020/7/10 8:18
 * description: 22
 *
 *   链表中倒数第k个节点/
 *
 *   解决：快慢指针
 *
 */
public class GetKthFromEnd_offer22 {


    public ListNode getKthFromEnd(ListNode head, int k) {

            ListNode cur;
            ListNode pre;
            cur = pre = head;

            for ( int i = 0; i < k; ++i ) {
                cur = cur.next;
            }

            while ( cur != null ) {
                cur = cur.next;
                pre = pre.next;
            }

            return pre;
    }


}
