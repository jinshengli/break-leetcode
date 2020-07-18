package linklist;

/**
 * create by ljs on 2020/7/10 19:05
 * description:
 *
 *      判断单链表是不是回文链表
 *
 *
 */
public class IsPalindrome_m {


    public boolean isPalindrome(ListNode head) {

        if ( head == null || head.next == null )
            return true;

        ListNode mid = findMidNode(head);

        ListNode rightNode = reverseLink(mid.next);

        boolean res = isEqualLink(head, rightNode);

        return res;

    }

    private boolean isEqualLink(ListNode head, ListNode rightNode) {

        boolean isEq = true;

        while ( isEq && rightNode != null ) {
            // 为啥不能用 head 为判断结束条件。 指向中间节点，
           if ( head.val != rightNode.val )
               isEq = false;
           head = head.next;
           rightNode = rightNode.next;
        }

        return isEq;

    }

    private ListNode reverseLink(ListNode head) {

        if ( head == null || head.next == null ) {
            return head;
        }

        ListNode cur = reverseLink(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    private ListNode findMidNode(ListNode head) {

        // 快慢指针， 快的每次走两步，慢的走一步

        /**
         *  1 -> 2 -> 3 -> 4
         *
         *  结束时：
         *  fast = 3
         *  flow = 2
         *
         *  1 - 2 - 3 - 4 - 5
         *  结束时：
         *  fast = 5
         *  flow = 3
         */

        ListNode fast = head;
        ListNode slow = head;
        while ( fast.next != null && fast.next.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }


        return slow;
    }


}
