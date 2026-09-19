class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            addWord(word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root);
            }
        }

        return ans;
    }

    public void addWord(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int idx = c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.word = word;
    }

    public void dfs(char[][] board, int row, int col, TrieNode node) {

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] == '#') {
            return;
        }

        char c = board[row][col];

        int idx = c - 'a';

        if (node.children[idx] == null) {
            return;
        }

        node = node.children[idx];

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        dfs(board, row - 1, col, node);
        dfs(board, row + 1, col, node);
        dfs(board, row, col - 1, node);
        dfs(board, row, col + 1, node);

        board[row][col] = c;
    }
}