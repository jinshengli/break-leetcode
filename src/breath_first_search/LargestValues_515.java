package breath_first_search;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * create by ljs on 2020/7/17 19:43
 * description:
 *
 *  515. 在每个树行中找最大值
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 *       [1,3,9]
 *
 *
 */

public class LargestValues_515 {

    public List<Integer> largestValues(TreeNode root) {

        if ( root == null ) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> result = new LinkedList<>();
        while ( !queue.isEmpty() ) {

            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for ( int i =0; i < size; ++i ) {

                TreeNode poll = queue.poll();
                max = Math.max(poll.val, max);
                if ( poll.left != null )
                    queue.offer(poll.left);

                if ( poll.right != null )
                    queue.offer(poll.right);
            }

            // 找到一层的最大值。
            result.add(max);
        }

        return result;
    }


}
