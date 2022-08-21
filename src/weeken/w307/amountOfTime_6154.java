package weeken.w307;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;


/**
 * 6154. 感染二叉树需要的总时间
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 *
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 *
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 * 返回感染整棵树需要的分钟数。
 *
 */
public class amountOfTime_6154 {

    TreeNode startNode = null;
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parentNodeMap = new HashMap<>();
        dfs(root, start, parentNodeMap);
        HashSet<TreeNode> vis =  new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(startNode);
        vis.add(startNode);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null && !vis.contains(node.left)) {
                    queue.add(node.left);
                    vis.add(node.left);
                }
                if (node.right != null && !vis.contains(node.right)) {
                    queue.add(node.right);
                    vis.add(node.right);
                }
                if (parentNodeMap.containsKey(node) && !vis.contains(parentNodeMap.get(node))) {
                    queue.add(parentNodeMap.get(node));
                    vis.add(parentNodeMap.get(node));
                }
            }
        }
        return ans - 1;
    }

    private TreeNode dfs(TreeNode root, int start, HashMap<TreeNode, TreeNode> parentNodeMap) {
        if (root == null) {
            return null;
        }
        if (root.val == start) {
            startNode = root;
        }
        TreeNode left = dfs(root.left, start, parentNodeMap);
        TreeNode right = dfs(root.right, start, parentNodeMap);
        if (left != null) {
            parentNodeMap.put(left, root);
        }
        if (right != null) {
            parentNodeMap.put(right, root);
        }
        return root;
    }
}
