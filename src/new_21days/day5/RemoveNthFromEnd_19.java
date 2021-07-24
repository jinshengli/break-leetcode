package new_21days.day5;

import linklist.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 19. 删除链表的倒数第 N 个结点
 *
 *
 * @author ljs
 * @since 2021/7/24 上午12:19
 **/
public class RemoveNthFromEnd_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head, cur = head;
        // 提前n个节点 && 做好最后一个节点准备
        for (int i = 0; i < n && cur != null; ++i) {
            cur = cur.next;
        }
        if (cur == null)
            return head.next;
        while (cur != null) {
            cur = cur.next;
            if (cur == null) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    // todo 2。 使用栈 + dummy 节点
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        Deque<ListNode> stack = new LinkedList<>();

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (n > 0) {
            stack.pop();
            n--;
        }
        cur = stack.peek();
        cur.next = cur.next.next;
        return dummy.next;
    }


    // todo 3。使用一个dump 哑节点。 我们就不需要对头节点进行特殊的判断了。 1 <= n <= len(list)
    public ListNode removeNthFromEnd02(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        for (int i = 0; i < n && cur != null; ++i) {
            cur = cur.next; // 1 - 2 - 3 - 4 - null
        }                   // 1 -
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

}
