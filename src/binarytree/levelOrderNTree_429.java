package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * create by ljs on 2020/6/24 17:42
 * <p>
 * description: 水平遍历n叉数、
 *
 * 使用队列； 队列进入循环前，就可知道当前队列的大小，代表当前层的node个数。
 *
 *
 *
 */
public class levelOrderNTree_429 {


    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 当前队列【当前层次】中的node有多少个。
            int size = queue.size();
            // 当前层次的节点都需要保存。
            for (int i = 0; i < size; ++i) {
                Node poll = queue.poll();
                level.add(poll.val);
                // 当前节点遍历完之后 需要 将它的孩子保存到队列中。
                for (Node child : poll.children) {
                    queue.add(child);
                }
            }
            // 遍历完一层之后，需要保存这一层的结果数组，并且继续遍历下一层。
            // 下一层node,都保存到queue.
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}