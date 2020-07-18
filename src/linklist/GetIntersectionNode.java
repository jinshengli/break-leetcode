package linklist;

import java.util.HashSet;

/**
 * create by ljs on 2020/7/10 17:44
 * description:  面试题 02.07. 链表相交
 *
 *  相交指的是 两链表使用同一个node节点
 *
 *  // 还有个解法；
 *
 *
 */
public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 先使用一个set保持；然后判断呗
        HashSet<ListNode> nodeHashSet = new HashSet<>();
        ListNode cur = headA;
        while ( cur != null ) {
            nodeHashSet.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while ( cur != null ) {
            if ( nodeHashSet.contains(cur) ) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }







}
