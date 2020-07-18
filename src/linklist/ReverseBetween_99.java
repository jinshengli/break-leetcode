package linklist;

/**
 * create by ljs on 2020/7/11 9:10
 * description:  翻转链表的一部分
 *
 *
 * 开始思路：
 *
 *   需要记录 m 的前驱节点； n节点的后驱节点。
 *
 *
 */
public class ReverseBetween_99 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // 找到 第m个节点的前驱 node； preM
        ListNode preM = head;
        int k = 1;
        while ( k < m-1 ) {
            preM = preM.next;
            k ++ ;
        }

        ListNode nextPre = preM;  // 去到n节点
        // 找到n 节点
        while ( k <= n  ) {
            nextPre = nextPre.next;
            k++;
        }

        ListNode lastNode = nextPre.next; // 后驱

        nextPre.next = null;



        // 反转 m， n 之间的链表
        ListNode nowNode = reverse(preM.next); // 反转后的头节点。

        // 回复链表
        preM.next = nowNode;
        preM.next = lastNode;


        return head;

    }

    private ListNode reverse(ListNode head) {

        // 结束条件
        if ( head == null || head.next == null ) {
            return head;
        }

        ListNode cur = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return cur;
    }


}
