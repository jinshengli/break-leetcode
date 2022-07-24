package linklist;


/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 */
public class ReverseKGroup_25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode lastNode = head;
        for (int i = 1; i < k && lastNode != null; ++i) {
            lastNode = lastNode.next;
        }
        if (lastNode == null) {
            return head;
        }

        ListNode nextBegin = lastNode.next;
        ListNode next = reverseKGroup(nextBegin, k);
        lastNode.next = null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = next;
        return pre;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 1; i <=4; ++i) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        print(dummy.next);

        ListNode listNode = reverseKGroup(dummy.next, 2);
        print(listNode);
    }

    private static void print(ListNode cur) {
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println(".......");
    }
}
