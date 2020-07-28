package linklist;

/**
 * create by ljs on 2020/7/20 13:37
 * description:  合并两个有序的链表
 */
public class MergeTwoLists_offer25 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        mergeTwoLists(l1, l2, head);

        return head.next;
    }

    /**
     *  迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {

        ListNode dump = new ListNode(-1);
        ListNode head = dump;
        while ( l1 != null && l2 != null ) {
            if ( l1.val < l2.val ) {
                head.next = l1;
                l1 = l1.next;
            } else  {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 != null ? l1 : l2;
        return dump.next;

    }




    /**
     *  递归 合并两个有序链表
     * @param l1
     * @param l2
     * @param head
     */
    private void mergeTwoLists(ListNode l1, ListNode l2, ListNode head) {

        if ( l1 == null ) {
            head.next = l2;
            return;
        }

        if ( l2 == null ) {
            head.next = l1;
            return;
        }

        if ( l1.val < l2.val ) {
            head.next = l1;
            mergeTwoLists(l1.next, l2, head.next);
        } else {
            head.next = l2;
            mergeTwoLists(l1, l2.next, head.next);
        }

    }


}
