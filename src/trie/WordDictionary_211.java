package trie;


import binarytree.TreeNode;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *1 <= word.length <= 25
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 10^4 次 addWord 和 search
 */
public class WordDictionary_211 {

    TrieNode root;
    public WordDictionary_211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null) {
                    if (dfs(child, word, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        return node.children[c - 'a'] != null && dfs(node.children[c - 'a'], word, index + 1);
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
        public void insert(String word) {
            TrieNode curNode = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curNode.children[index] == null) {
                    curNode.children[index] = new TrieNode();
                }
                curNode = curNode.children[index];
            }
            curNode.isEnd = true;
        }
    }
}
