package depth_first_search;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 * 二叉树的节点个数的范围是 [1,104]
 * -2^31 <= Node.val <= 2^31 - 1
 *
 */
public class FindBottomLeftValue_513 {

    private int ans = 0;
    private int maxDepth = -1;


    // bfs. 一层层遍历。 root节点入队
    // 1. 来到新的一层，判断这层的节点数
    // 2. 一次处理完这层的节点
    // 3. 判断下一层的节点数，接着1,2步骤
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.peek();
            ans = peek.val;
            int sizeOfEachLevel = queue.size();
            while (sizeOfEachLevel > 0) {
                TreeNode next = queue.poll();
                if (next.left != null) {
                    queue.add(next.left);
                }
                if (next.right != null) {
                    queue.add(next.right);
                }
                sizeOfEachLevel--;
            }
        }
        return ans;
    }


    // bfs. 一层层 + 最右边变量。 最后变量的节点一定是最底层，最左的
    public int findBottomLeftValue02(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            ans = poll.val;
        }
        return ans;
    }


    // dfs
    public int findBottomLeftValue01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (maxDepth < level) {
                maxDepth = level;
                ans = root.val;
            }
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
