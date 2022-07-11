package trie;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 1268. 搜索推荐系统
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 *
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 *
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 *
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 *
 * 1 <= products.length <= 1000
 * 1 <= Σ products[i].length <= 2 * 10^4
 * products[i]中所有的字符都是小写英文字母。
 * 1 <= searchWord.length <= 1000
 * searchWord中所有字符都是小写英文字母。
 *
 *
 */
public class SuggestedProducts {

    Trie root = new Trie();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        for (String product : products) {
            root.insert(product);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); ++i) {
            List<String> res = new ArrayList<>();
            String prefix = searchWord.substring(0, i);
            Trie node = searPrefixNode(root, prefix);
            dfs(node, res, prefix);
            ans.add(res);
        }

        return ans;
    }

    private Trie searPrefixNode(Trie root, String prefix) {
        for (char c : prefix.toCharArray()) {
           int index = c - 'a';
           if (root.children[index] == null) return null;
           root = root.children[index];
        }
        return root;
    }

    private void dfs(Trie root, List<String> res, String prefix) {
        if (root == null || res.size() == 3) {
            return;
        }
        if (root.isEnd) res.add(prefix);
        for (int i = 0; i < 26; ++i) {
            if (root.children[i] != null) {
                char c = (char) (i + 'a');
                dfs(root.children[i], res, prefix + c);
            }
        }
    }

    class Trie {
        Trie[] children;
        boolean isEnd;
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
    }

    public static void main(String[] args) {
        SuggestedProducts suggestedProducts = new SuggestedProducts();
        System.out.println(suggestedProducts.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));

    }
}
