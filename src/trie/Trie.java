package trie;


public class Trie {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); ++i) {
            int childIndex = word.charAt(i) - 'a';
            if (node.children[childIndex] == null) {
                node.children[childIndex] = new TrieNode();
            }
            node = node.children[childIndex];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); ++i) {
            int childIndex = word.charAt(i) - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            node = node.children[childIndex];
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); ++i) {
            int childIndex = prefix.charAt(i) - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            node = node.children[childIndex];
        }
        return true;
    }
}
