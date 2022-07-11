package trie;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-trie-prefix-tree
 *
 *
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次

 *
 */
public class Trie_208 {

    private Trie_208[] children;
    private boolean isEnd;

    public Trie_208() {
        children = new Trie_208[26];
        isEnd = false;
    }

    public void insert(String word) {
        char[] words = word.toCharArray();
        Trie_208 node = this;
        for (int i = 0; i < words.length; ++i) {
            int childIndex = words[i] - 'a';
            Trie_208 child = node.children[childIndex];
            if (child == null) {
                node.children[childIndex] = new Trie_208();
            }
            node = node.children[childIndex];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] words = word.toCharArray();
        Trie_208 node = this;
        for (int i = 0; i < words.length; ++i) {
            int childIndex = words[i] - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            node = node.children[childIndex];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        Trie_208 node = this;
        for (int i = 0; i < words.length; ++i) {
            int childIndex = words[i] - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            node = node.children[childIndex];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie_208 trie = new Trie_208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));


    }

}
