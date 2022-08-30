package binarytree;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *
 */
public class DeepestLeavesSum_1302 {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int lastSum = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            lastSum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = deque.pollFirst();
                lastSum += node.val;
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return lastSum;
    }
}
