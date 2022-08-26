package binarysearch;

import binarytree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 *
 * 树的 最大宽度 是所有层中最大的 宽度 。
 *
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，
 * 两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 *
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 *
 *
 * 满二叉数。 0编号开始，
 * i ；  左： 2*i + 1。 右编号： 2*i + 2
 *
 * 最左的编号 L。 最右的编号：R
 * 宽度：R - L + 1
 *
 *
 */

public class WidthOfBinaryTree_662 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode root, int level, int pos) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, pos);
        dfs(root.left, level + 1, pos * 2 + 1);
        ans = Math.max(ans, pos - map.get(level) + 1);
        dfs(root.right, level + 1, pos * 2 + 2);
    }

    // bfs
    public int widthOfBinaryTree01(TreeNode root) {
        int width = 0;
        if (root == null) {
            return width;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            width = Math.max(width, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = queue.pollFirst();
                if (curNode.left != null) {
                    curNode.left.val = 2*curNode.val + 1;
                    queue.addLast(curNode.left);
                }
                if (curNode.right != null) {
                    curNode.right.val = 2 * curNode.val + 2;
                    queue.addLast(curNode.right);
                }
            }
        }
        return width;
    }

    public int widthOfBinaryTree03(TreeNode root) {
        int width = 0;
        if (root == null) {
            return width;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> idxQueue = new LinkedList<>();
        queue.addLast(root);
        idxQueue.addLast(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            width = Math.max(width, idxQueue.peekLast() - idxQueue.peekFirst() + 1);
            while (size-- > 0) {
                TreeNode curNode = queue.pollFirst();
                int index = idxQueue.pollFirst();
                if (curNode.left != null) {
                    queue.addLast(curNode.left);
                    idxQueue.addLast(index * 2 + 1);
                }
                if (curNode.right != null) {
                    queue.addLast(curNode.right);
                    idxQueue.addLast(index * 2 + 2);
                }
            }
        }
        return width;
    }

}
