package linklist;

import java.util.Stack;

/**
 * create by ljs on 2020/7/11 8:35
 * description:
 *
 * 给你两个 非空 链表来代表两个非负整数。
 * 数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 *
 *
 */
public class AddTwoNumbers_445 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while ( cur1 != null ) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }

        while ( cur2 != null ) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }



        ListNode head = null;

        // 弹出它们的值。
        int curry = 0;
        while ( !stack1.isEmpty() && !stack2.isEmpty() ) {

            Integer pop1 = stack1.pop();
            Integer pop2 = stack2.pop();


            int val = (pop1+pop2 + curry) % 10;
            curry = (pop1 + pop2 + curry) / 10; // 新的进位
            ListNode newNode = new ListNode(val);

            if ( head == null ) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }

        }

        while ( ! stack1.isEmpty() ) {

            // curry + val =
            Integer pop = stack1.pop();
            int val = (curry + pop)%10;
            curry = (curry + pop) / 10;
            ListNode newNode = new ListNode(val);
            if ( head == null ) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }

        }

        while ( ! stack2.isEmpty() ) {

            // curry + val =
            Integer pop = stack2.pop();
            int val = (curry + pop)%10;
            curry = (curry + pop) / 10;
            ListNode newNode = new ListNode(val);
            if ( head == null ) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }

        }

        // 可能还有一个进位

        if ( curry != 0 ) {
            ListNode newNode = new ListNode(curry);
            newNode.next = head;
            head = newNode;
        }

        return head;

    }



}
