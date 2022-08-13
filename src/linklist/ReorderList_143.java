package linklist;


import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 链表的长度范围为 [1, 5 * 10^4]
 * 1 <= node.val <= 1000
 *
 *
 */
public class ReorderList_143 {

    public void reorderList02(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        ListNode node1 = head;
        ListNode node2 = reverse(next);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            cur.next = node1;
            node1 = node1.next;
            cur = cur.next;
            cur.next = node2;
            node2 = node2.next;
            cur = cur.next;
        }
        cur.next = node1;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nx = null;
        while (cur != null) {
            nx = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nx;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 0; i < nums.length; ++i) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        ReorderList_143 test = new ReorderList_143();
        test.reorderList02(head);
    }


    public void reorderList01(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int left = 0; int right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }

    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = dummy;

        int left = 0; int right = list.size() - 1;
        while (left < right) {
            cur.next = list.get(left);
            cur = cur.next;
            cur.next = list.get(right);
            cur = cur.next;
            left++;
            right--;
        }
        if (left == right) {
            cur.next = list.get(left);
            cur = cur.next;

        }
        cur.next = null;
        head = dummy.next;
    }

}
