package linklist;

/**
 * create by ljs on 2020/7/10 9:40
 * description:  24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 */
public class ReverseList_offer24 {


    /**
     *     通过递归解决
     *
     *     分成子问题，处理子问题。
     *
     *     2 -> 3 -> 4 -> 5
     *
     *          3 -> 4 -> 5
     *
     *               4 -> 5
     *
     *                    5
     *
     *          3 -> 4 <- 5
     *
     *     2 -> 3 <- 4 <- 5
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        // 子问题结束条件  直到一个节点的链表，或者 一开始链表为空
        if ( head == null || head.next == null ) {
            return head;
        }

        ListNode cur = reverseList(head.next);
        // 翻转当前node的下一个节点的指针  head.next.next = head
        head.next.next = head;
        head.next = null;

        // 返回链表末尾节点。
        return cur;
    }

    /**
     *  通过迭代
     *
     *
     *  pre: cur的前一个
     *  cur: 当前遍历
     *  tmp: 暂存cur的下一个位置
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode cur;
        ListNode pre;
        ListNode tmp;
        cur = head;
        pre = null;
        if ( cur == null || cur.next == null )
            return cur;
        while ( cur != null ) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
       return pre;
    }


    public ListNode reverseList2(ListNode head) {

        ListNode cur = head, pre = null;
        if ( head == null || head.next == null )
            return head;
        while ( cur != null ) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }





}
