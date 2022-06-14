package recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class Partition_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, 0, path, ans);
        return ans;
    }

    private void dfs(String s, int start, List<String> path, List<List<String>> ans) {
        if (start >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= s.length() - start; ++i) {
            String sub = s.substring(start, start + i);
            if (isOk(sub)) {
                path.add(sub);
                dfs(s, start + i, path, ans);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isOk(String sub) {
        if (sub == null) {
            return true;
        }
        char[] chars = sub.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Partition_131 partition_131 = new Partition_131();
        List<List<String>> aab = partition_131.partition("aaaa");
        for (List<String> strings : aab) {
            System.out.println(strings);
        }
    }

}
