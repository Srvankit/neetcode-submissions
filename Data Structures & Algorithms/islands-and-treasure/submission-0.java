
class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int INF = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add all treasure chest positions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: Define four directions
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Step 3: Perform BFS
        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];

            // Step 4: Explore all four directions
            for (int[] direction : directions) {

                int newRow = r + direction[0];
                int newCol = c + direction[1];

                // Step 5: Check boundaries
                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols) {
                    continue;
                }

                // Step 6: Skip walls and already visited cells
                if (grid[newRow][newCol] != INF) {
                    continue;
                }

                // Step 7: Update distance
                grid[newRow][newCol] = grid[r][c] + 1;

                // Step 8: Add updated cell to queue
                q.offer(new int[]{newRow, newCol});
            }
        }
    }
}