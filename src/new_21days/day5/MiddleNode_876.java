package new_21days.day5;

import linklist.ListNode;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author ljs
 * @since 2021/7/23 下午11:29
 **/
public class MiddleNode_876 {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = head, cur = head.next;
        while (cur != null) {
            cur = cur.next;
            cur = cur != null ? cur.next : null;
            pre = pre.next;
        }
        return pre;
    }

}
