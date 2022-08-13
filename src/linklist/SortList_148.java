package linklist;


/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
 *
 *
 *  链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -10^5 <= Node.val <= 10^5
 *
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 */
public class SortList_148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            cur = cur.next.next;
            pre = pre.next;
        }

        // fen kai
        ListNode p = pre.next;
        pre.next = null;
        ListNode f1 = sortList(head);
        ListNode f2 = sortList(p);

        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        while (f1 != null && f2 != null) {
            if (f1.val <= f2.val) {
                curNode.next = f1;
                f1 = f1.next;
            } else {
                curNode.next = f2;
                f2 = f2.next;
            }
            curNode = curNode.next;
        }

        curNode.next = f1 == null ? f2 : f1;

        return dummy.next;
    }

    public static void main(String[] args) {

        int[] nums = {2,1,3};
        ListNode head = new ListNode(4);
        ListNode cur = head;
        for (int i = 0; i < nums.length; ++i) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        SortList_148 test = new SortList_148();
        test.sortList(head);
    }
}
