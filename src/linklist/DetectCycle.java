package linklist;

import java.util.HashMap;
import java.util.HashSet;

/**
 * create by ljs on 2020/7/20 23:51
 * description:  142. 环形链表 II
 *
 *
 */
public class DetectCycle {


    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();

        while ( head != null ) {

            if ( visited.contains(head) ) {
                return head;
            }

            visited.add(head);
            head = head.next;
        }
        return null;

    }
}
