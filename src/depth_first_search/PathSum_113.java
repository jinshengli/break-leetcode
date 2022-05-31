package depth_first_search;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_113 {


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        solu(root, targetSum, ans, new ArrayList<Integer>());
        return ans;
    }

    private void solu(TreeNode root, int targetSum, List<List<Integer>> ans, ArrayList<Integer> paths) {
        if (root == null) {
            return;
        }
        paths.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            ans.add(new ArrayList<>(paths));
        }

        solu(root.left, targetSum-root.val, ans, paths);
        solu(root.right, targetSum- root.val, ans, paths);
        paths.remove(paths.size() - 1);
    }


    public List<List<Integer>> pathSum01(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, targetSum, 0, path, ans);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, int totalSum, ArrayList<Integer> path, ArrayList<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        totalSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (totalSum == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        }

        dfs(root.left, targetSum, totalSum, path, ans);
        dfs(root.right, targetSum, totalSum, path, ans);
        // 回溯
        path.remove(path.size() - 1);
    }
}
