package linklist;

import java.util.Stack;

/**
 * create by ljs on 2020/7/10 8:23
 * description:
 *  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  使用栈、
 *
 *
 */
public class ReversePrint_offer06 {


    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode cur = head;

        while ( cur != null ) {
            stack.push(cur.val);
            cur = cur.next;
        }

        int[] res = new int[stack.size()];
        int index = 0;
        while ( !stack.isEmpty() ) {
            res[index++] = stack.pop();
        }

        return res;

    }

}
