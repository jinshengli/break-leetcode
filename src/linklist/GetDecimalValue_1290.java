package linklist;

/**
 * create by ljs on 2020/7/10 13:28
 * description:
 *
 *
 * 给你一个单链表的引用结点 head。
 * 链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式
 *
 * 转成十进制。、
 *
 */


public class GetDecimalValue_1290 {


    public int getDecimalValue(ListNode head) {

        int rs = 0;

        ListNode cur = head;

        while ( cur != null ) {
            rs = (rs + cur.val)*2;
            cur = cur.next;
        }

        return rs/2;
    }


}
