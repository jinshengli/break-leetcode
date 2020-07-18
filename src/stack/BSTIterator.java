package stack;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ljs on 2020/7/11 19:16
 * description:   173.  二叉搜索树迭代器
 *
 *  调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *  前 遍历。
 *
 *
 */
public class BSTIterator {


    List<Integer> list = new ArrayList<>();
    int count;


    public BSTIterator(TreeNode root) {

        generatorStack(root);
        count = 0;

    }

    private void generatorStack(TreeNode root) {

        if ( root == null ) {
            return;
        }

        if ( root.left != null ) {
            generatorStack(root.left);
        }

        list.add(root.val);

        if ( root.right != null ) {
            generatorStack(root.right);
        }



    }


    /** @return the next smallest number */
    public int next() {

        return list.get(count++);

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return count < list.size();
    }




}
