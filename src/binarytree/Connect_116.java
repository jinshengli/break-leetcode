package binarytree;

import vo.Node;

import java.util.LinkedList;
import java.util.Queue;


public class Connect_116 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 遍历每一层的长度
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node poll = queue.poll();
                if (i < size -1) {
                    poll.next = queue.peek();
                }

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }
}
