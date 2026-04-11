class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
    if (index == word.length()) {
        return node.isEnd;
    }
    
    char c = word.charAt(index);
    if (c == '.') {
        // Try all possible children
        for (TrieNode child : node.children) {
            if (child != null && searchHelper(word, index + 1, child)) {
                return true;
            }
        }
        return false;
    } else {
        int i = c - 'a';
        if (node.children[i] == null) {
            return false;
        }
        return searchHelper(word, index + 1, node.children[i]);
    }
}
}