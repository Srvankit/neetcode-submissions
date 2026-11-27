class Solution {
    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int freshcount = 0;

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Find all rotten and fresh oranges
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    freshcount++;
                }
            }
        }

        if (freshcount == 0) {
            return 0;
        }

        int minutes = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Step 2: Multi-source BFS
        while (!q.isEmpty()) {

            int size = q.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] current = q.poll();

                for (int[] dir : directions) {

                    int newrow = current[0] + dir[0];
                    int newcol = current[1] + dir[1];

                    // Boundary check
                    if (newrow < 0 || newrow >= row ||
                        newcol < 0 || newcol >= col) {
                        continue;
                    }

                    // Only fresh oranges can rot
                    if (grid[newrow][newcol] != 1) {
                        continue;
                    }

                    // Rot the fresh orange
                    grid[newrow][newcol] = 2;

                    q.offer(new int[]{newrow, newcol});

                    freshcount--;
                    rottedThisMinute = true;
                }
            }

            if (rottedThisMinute) {
                minutes++;
            }
        }

        return freshcount == 0 ? minutes : -1;
    }
}