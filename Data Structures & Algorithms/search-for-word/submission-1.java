class Solution {

    public boolean exist(char[][] board, String word) {

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {

                if(backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, String word,
                             int row, int col, int index) {

        // We found the complete word
        if(index == word.length()) {
            return true;
        }

        // Invalid cell
        if(row < 0 || row >= board.length ||
           col < 0 || col >= board[0].length ||
           board[row][col] == '#') {
            return false;
        }

        // Wrong character
        if(board[row][col] != word.charAt(index)) {
            return false;
        }

        // Choose
        char original = board[row][col];
        board[row][col] = '#';

        // Explore
        boolean found =
            backtrack(board, word, row - 1, col, index + 1) ||
            backtrack(board, word, row + 1, col, index + 1) ||
            backtrack(board, word, row, col - 1, index + 1) ||
            backtrack(board, word, row, col + 1, index + 1);

        // Undo
        board[row][col] = original;

        return found;
    }
}