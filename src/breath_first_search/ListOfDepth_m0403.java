package breath_first_search;

import binarytree.TreeNode;
import linklist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/30 20:04
 * description:
 *
 *  面试题 04.03. 特定深度节点链表
 *
 *  输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 *
 *
 * 按层次遍历，并且将每一层串成一个链表。
 *
 * 注意细节：
 *
 *      队列按层次遍历，
 *
 *      每一层出队是节点连接， +个头节点比较方便，
 *
 *      ArrayList 转成 数组。
 *
 */
public class ListOfDepth_m0403 {


    public ListNode[] listOfDepth(TreeNode tree) {

        if ( tree == null )
            return null;
        ArrayList<ListNode> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while ( !queue.isEmpty() ) {

            ListNode head = new ListNode(-1);
            ListNode cur = head;
            int size = queue.size();
            for ( int i = 0; i < size; ++i ) {
                TreeNode treeNode = queue.poll();
                cur.next = new ListNode(treeNode.val);
                cur = cur.next;
//                result.add(cur); 这个时候不应该入队
                // 左右子节点入队
                if ( treeNode.left != null )
                    queue.add(treeNode.left);
                if ( treeNode.right != null )
                    queue.add(treeNode.right);
            }
            result.add(head.next); // 遍历完一层才能入队
        }

        return result.toArray(new ListNode[result.size()]);
    }

}
