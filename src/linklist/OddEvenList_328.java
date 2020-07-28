package linklist;

/**
 * create by ljs on 2020/7/20 21:17
 * description:     328. 奇偶链表
 */
public class OddEvenList_328 {


    public ListNode oddEvenList(ListNode head) {

        if ( head == null || head.next == null || head.next.next == null )
            return head;
        ListNode odd = head, even = head.next;
        ListNode dumny = new ListNode(-1);
        dumny.next = even;

        while ( even != null && even.next != null ) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = dumny.next;
        return head;
    }


}
