class Solution {

    List<List<String>> ans = new ArrayList<>();

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Empty board
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, n);

        return ans;
    }

    public void backtrack(char[][] board, int row, int n) {

        // All queens placed
        if(row == n) {

            List<String> current = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            ans.add(current);
            return;
        }

        // Try every column in this row
        for(int col = 0; col < n; col++) {

            // Check column
            if(cols.contains(col)) {
                continue;
            }

            // Check diagonals
            if(diag1.contains(row - col)) {
                continue;
            }

            if(diag2.contains(row + col)) {
                continue;
            }

            // Choose
            board[row][col] = 'Q';

            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            // Explore
            backtrack(board, row + 1, n);

            // Undo
            board[row][col] = '.';

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}