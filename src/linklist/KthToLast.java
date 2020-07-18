package linklist;

/**
 * create by ljs on 2020/7/10 13:37
 * description:  返回倒数第 k 个节点
 *
 *
 */
public class KthToLast {


    public int kthToLast(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;

        while ( fast != null && k >0 ) {
            fast = fast.next;
            k--;
        }

        while ( fast != null ) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;

    }


}
