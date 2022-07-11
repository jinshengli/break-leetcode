package trie;


import java.util.HashSet;

/**
 * 676. 实现一个魔法字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，
 * 使得所形成的新单词存在于你构建的字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 * 1 <=dictionary.length <= 100
 * 1 <=dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <=searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 *
 *
 */
public class MagicDictionary_676 {

    HashSet<String> set = new HashSet<>();

    public void buildDict1(String[] dictionary) {
        for (String s : dictionary) {
            set.add(s);
        }
    }

    public boolean search1(String searchWord) {
        char[] chars = searchWord.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char aChar = chars[i];
            for (int j = 'a'; j <= 'z'; ++j) {
                if (aChar == j) {
                    continue;
                }
                chars[i] = (char) j;
                if (set.contains(String.valueOf(chars))) return true;
            }
            chars[i] = aChar;
        }
        return false;
    }




    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
        public void insert(String word) {
            TrieNode cur = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isEnd = true;
        }
    }

    TrieNode root;
    public MagicDictionary_676() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            root.insert(s);
        }
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, false);
    }

    private boolean dfs(TrieNode node, String searchWord, int start, boolean modified) {
        if (start == searchWord.length()) {
            return node.isEnd && modified;
        }
        int index = searchWord.charAt(start) - 'a';
        if (node.children[index] != null) {
            // 不能直接return, 因为放回false的话，下面的修改一个字符就不出现了
            if (dfs(node.children[index], searchWord, start + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (node.children[i] != null && i != index) {
                    if (dfs(node.children[i], searchWord, start + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // 这个dfs是错误的，原因是，["hello","hallo","leetcode"]], ["hello"]
    //  在没有修改的情况下，你可以去修改一个字符。而不是在没匹配到字符的时候才去修改字符。，，，  我草
    private boolean dfs01(TrieNode root, String searchWord, int start, boolean modified) {
        if (start == searchWord.length()) {
            return root.isEnd && modified;
        }

        char c = searchWord.charAt(start);
        if (root.children[c - 'a'] == null) {
            // 需要变化 但是变化过了
            if (modified) return false;
            for (TrieNode child : root.children) {
                if (child != null) {
                    if (dfs01(child, searchWord, start + 1, true)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return dfs01(root.children[c - 'a'], searchWord, start + 1, modified);
    }

    public static void main(String[] args) {
        MagicDictionary_676 magicDictionary_676 = new MagicDictionary_676();
        magicDictionary_676.buildDict(new String[]{"hello","hallo","leetcode"});
        System.out.println(magicDictionary_676.search("hello"));
    }


}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
