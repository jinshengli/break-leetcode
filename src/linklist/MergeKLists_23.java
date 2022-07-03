package linklist;


import java.util.List;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 */

public class MergeKLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int left, int right) {
        if (lists.length == 0) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;
        // [left, mid]
        ListNode leftNode = mergeList(lists, left, mid);
        ListNode rightNode = mergeList(lists, mid + 1, right);
        if (leftNode == null) {
            return rightNode;
        }

        if (rightNode == null) {
            return leftNode;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                cur.next = leftNode;
                leftNode = leftNode.next;
            } else {
                cur.next = rightNode;
                rightNode = rightNode.next;
            }
            cur = cur.next;
        }

        if (leftNode != null) {
            cur.next = leftNode;
        }

        if (rightNode != null) {
            cur.next = rightNode;
        }
        return dummy.next;
    }
}
