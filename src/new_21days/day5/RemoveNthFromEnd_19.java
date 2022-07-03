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

    // 删除第 （链表长度 - n + 1）个节点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = dummy;
        for (int i = 1; i < len - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
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


    //
    public ListNode removeNthFromEnd03(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; ++i) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }


}
