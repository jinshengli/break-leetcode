package linklist;


/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 */
public class ReverseBetween_91 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preLeftNode = dummy;
        ListNode cur = head;
        for (int i = 1; i < left; ++i) {
            cur = cur.next;
            preLeftNode = preLeftNode.next;
        }
        ListNode nextRightNode = null;
        for (int i = left; i < right; ++i) {
            cur = cur.next;
        }
        nextRightNode = cur.next;
        ListNode leftNode = preLeftNode.next;

        preLeftNode.next = null;
        cur.next = null;
        reverse(leftNode);

        preLeftNode.next = cur;
        leftNode.next = nextRightNode;

        return dummy.next;
    }

    private void reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode nx = null;
        while (cur != null) {
            nx = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nx;
        }
    }

}
