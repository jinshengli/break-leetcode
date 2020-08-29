package binarytree;

import java.util.LinkedList;


/**
 * create by ljs on 2020/8/19 14:58
 * description:
 *
 *  你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 1，2，#,#,3,4，#，#，5，#，#,
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *  同理后序遍历也能完成
 *  seri(root.left)
 *  seri(root.right)
 *  ....root...
 *
 *
 *
 *  层次遍历
 *
 */
public class Codec_297 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    // 先序列化左子树；再次序列化右子树
    private void serialize(TreeNode root, StringBuilder sb) {
        if ( root == null ) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        LinkedList<String> list = new LinkedList<>();
        String[] nodes = data.split(",");
        for (String node : nodes) {
            list.add(node);
        }


        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> list) {

        if ( list == null )
            return null;
        String node = list.removeFirst();
        if ( node.equals("#") ) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    public static void main(String[] args) {

        String data = "1,2,#,#,3,4,#,#,5,#,#,";
        String[] split = data.split(",");
        for ( int i = 0; i < split.length; ++i )
            System.out.println(split[i]);
    }


}
