package linklist;


/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Partition_86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode firstDummy = new ListNode(-1);
        ListNode fst = firstDummy;
        ListNode secondDummy = new ListNode(-1);
        ListNode sce = secondDummy;

        while (head != null) {
            if (head.val < x) {
                fst.next = head;
                fst = fst.next;
            } else {
                sce.next = head;
                sce = sce.next;
            }
            head = head.next;
            fst.next = null;
            sce.next = null;
        }

        fst.next = secondDummy.next;
        return firstDummy.next;
    }
}
