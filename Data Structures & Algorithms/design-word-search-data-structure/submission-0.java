class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode node = root;

        for(char c : word.toCharArray()) {

            int idx = c - 'a';

            if(node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(TrieNode node, String word, int index) {

        if(index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        // Normal character
        if(c != '.') {

            int idx = c - 'a';

            if(node.children[idx] == null) {
                return false;
            }

            return dfs(node.children[idx], word, index + 1);
        }

        // '.' → try every possible character
        for(int i = 0; i < 26; i++) {

            if(node.children[i] != null) {

                if(dfs(node.children[i], word, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}