package linklist;


import java.util.HashSet;

/**
 * create by ljs on 2020/7/10 17:22
 * description:
 *
 *  编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 *
 */
public class RemoveDuplicateNodes {

    /**
     *  使用 hashSet 缓存已经存在的 val。
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {

        HashSet<Integer> set = new HashSet<>(); // 缓存链表的值
        ListNode pre = null;
        ListNode cur = head;
        // cur == null || cur.next == null  空 or 只有一个链表
        while ( cur != null ) {

            // 判断该节点有没有存在过。
            if ( ! set.contains(cur.val) ) {
                set.add(cur.val);
                pre = cur;
                cur = cur.next;

            } else {
                pre.next = cur.next;
                cur = pre.next;
            }
        }

        return head;
    }



}
