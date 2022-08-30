package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CBTInserter_919 {

    List<TreeNode> treeNodeList;
    TreeNode root;
    public CBTInserter_919(TreeNode root) {
        treeNodeList = new ArrayList<>();
        this.root = root;
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pollFirst();
            treeNodeList.add(treeNode);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    // 0 1 2 3 4
    // size - 1 / 2
    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        if (treeNodeList.size() == 0) {
            root = newNode;
            treeNodeList.add(newNode);
            return -1;
        }
        int parentIndex = (treeNodeList.size() - 1 )/2;
        TreeNode pNode = treeNodeList.get(parentIndex);
        if (pNode.left == null) {
            pNode.left = newNode;
        } else {
            pNode.right = newNode;
        }
        treeNodeList.add(newNode);
        return pNode.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
