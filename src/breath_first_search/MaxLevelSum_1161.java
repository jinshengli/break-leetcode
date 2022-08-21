package breath_first_search;

import binarytree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxLevelSum_1161 {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxSum = root.val;
        int ans = 1;
        int levelNum = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            int levelSum = 0;
            levelNum++;
            for (int i = 0; i < levelSize; ++i) {
                TreeNode treeNode = deque.pollFirst();
                levelSum += treeNode.val;
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
            if (levelSum > maxSum) {
                ans = levelNum;
                maxSum = levelSum;
            }
        }
        return ans;
    }
}
