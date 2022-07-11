package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，返回所有二维网格上的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成  importance
 * words 中的所有字符串互不相同
 */

public class FindWords_212 {
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board.length == 0 || words.length == 0) {
            return ans;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                String startStr = board[i][j] + "";
                if (trie.isPrefix(startStr)) {
                    char tmp = board[i][j];
                    board[i][j] = '@';
                    dfs(board, i, j, startStr, trie, ans);
                    board[i][j] = tmp;
                }

            }
        }

        HashSet<String> set = new HashSet<>(ans);
        return set.stream().collect(Collectors.toList());
    }

    private void dfs(char[][] board, int i, int j, String word, Trie trie, List<String> ans) {
        if (trie.containWord(word)) {
            ans.add(word);
        }

        for (int k = 0; k < 4; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '@') {
                continue;
            }

            String curWord = word + board[x][y];
            if (trie.isPrefix(curWord)) {
                char tmp = board[i][j];
                board[i][j] = '@';
                dfs(board, x, y, curWord, trie, ans);
                board[i][j] = tmp;
            }
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean end = false;
        }

        public void insert(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.end = true;
        }

        public boolean containWord(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.end;
        }

        public boolean isPrefix(String prefix) {
            TrieNode node = this.root;
            for (int i = 0; i < prefix.length(); ++i) {
                int index = prefix.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        FindWords_212 findWords_212 = new FindWords_212();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] string = {"oath", "pea", "eat", "rain"};
        List<String> words = findWords_212.findWords(board, string);
        for (String word : words) {
            System.out.println(word);
        }
    }

}
