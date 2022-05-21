package linklist;

import java.util.List;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class AddTwoNumbers_2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            ListNode newNode = new ListNode(0);
            int sum = 0;
            if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = sum / 10;
            newNode.val = sum % 10;
            cur.next = newNode;
            cur = cur.next;
        }

        if (carry != 0 ) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }




    /**
     * 很烧的做法。可能想不到。null的用0代替
     */
    public ListNode addTwoNumbers001(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    /**
     *  个人想到比较朴素的算法，这个冗余代码比较多，需要考虑的场景比较多。
     */
    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int nextVal = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + nextVal;
            nextVal = sum / 10;
            ListNode listNode = new ListNode(sum%10);
            cur.next = listNode;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        /**
         * 在上面的循环结束，不要忘记考虑三种场景.
         * 1. l1 == null && l2 == null
         * 2. l1 != null && l2 == null
         * 3. l1 == null && l2 != null
         */

        if (l1 == null && l2 == null && nextVal == 1) {
            cur.next = new ListNode(nextVal);
            cur = cur.next;
        }

        if (l1 != null) {
            countLastList2(l1, cur, nextVal);
        }

        if (l2 != null) {
            countLastList2(l2, cur, nextVal);
        }
        return dummy.next;
    }

    // 前后指针
    private void countLastList2(ListNode l, ListNode cur, int nextVal) {
        // 先后节点。
        ListNode pre = null;
        while (l != null) {
            int sum = l.val + nextVal;
            nextVal = sum / 10;
            ListNode listNode = new ListNode(sum%10);
            cur.next = listNode;
            cur = cur.next;
            pre = l;
            l = l.next;
        }

        // 最后节点有进位
        if (pre != null && nextVal != 0) {
            cur.next = new ListNode(nextVal);
        }
    }


    // 循环到倒数第一个节点停止
    private void countLastList(ListNode l, ListNode cur, int nextVal) {
        // 确保 l != null
        while (l.next != null) {
            int sum = l.val + nextVal;
            nextVal = sum / 10;
            ListNode listNode = new ListNode(sum%10);
            cur.next = listNode;
            cur = cur.next;
            l = l.next;
        }

        // 到这里是 倒数第一个节点
        int sum = l.val + nextVal;
        nextVal = sum / 10;
        ListNode listNode = new ListNode(sum%10);
        cur.next = listNode;
        cur = cur.next;
        if (nextVal != 0) {
            cur.next = new ListNode(nextVal);
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 twoNumbers_2 = new AddTwoNumbers_2();
        int[] arr1 = {9,9,9,9};
        int[] arr2 = {9,9};
        ListNode l1 = getListNode(arr1);
        ListNode l2 = getListNode(arr2);

        ListNode listNode = twoNumbers_2.addTwoNumbers(l1, l2);

        printList(listNode);

    }

    private static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    private static ListNode getListNode(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < arr.length; ++i) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return dummy.next;
    }
}
