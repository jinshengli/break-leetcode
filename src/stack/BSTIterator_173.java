package stack;

import binarytree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * create by ljs on 2020/7/11 19:38
 * description:
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 使用栈保存 保存每个节点。  往栈中推左子树。
 *
 *
 */
public class BSTIterator_173 {


    Deque<TreeNode> stack = new LinkedList<>();


    public BSTIterator_173(TreeNode root) {

        TreeNode cur = root;
        _leftmost_inorder(cur);  // 左

    }

    private void _leftmost_inorder(TreeNode cur) {

        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

    }


    /** @return the next smallest number */
    public int next() {

        TreeNode node = stack.pop();
        int val = node.val;

        if ( node.right != null ) {
            _leftmost_inorder(node.right); // 左的左的左 依次进入stack
        }
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }


}
