class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;
        for (int[] row : grid) {
            for (int val : row) total += val;
        }

        long sum = 0;

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                sum += val;
                seen.add(val);
            }

            long other = total - sum;
            if (sum == other) return true;

            long diff = Math.abs(sum - other);
            if (diff > 100000) continue;

            if (sum > other) {
                if (canRemove(seen, (int) diff, i + 1, n, grid, 0, i, 0, n - 1)) return true;
            } else {
                if (exists(grid, i + 1, m - 1, 0, n - 1, (int) diff)) {
                    if (canRemove(null, (int) diff, m - (i + 1), n, grid, i + 1, m - 1, 0, n - 1)) return true;
                }
            }
        }

        sum = 0;
        seen.clear();

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];
                sum += val;
                seen.add(val);
            }

            long other = total - sum;
            if (sum == other) return true;

            long diff = Math.abs(sum - other);
            if (diff > 100000) continue;

            if (sum > other) {
                if (canRemove(seen, (int) diff, m, j + 1, grid, 0, m - 1, 0, j)) return true;
            } else {
                if (exists(grid, 0, m - 1, j + 1, n - 1, (int) diff)) {
                    if (canRemove(null, (int) diff, m, n - (j + 1), grid, 0, m - 1, j + 1, n - 1)) return true;
                }
            }
        }

        return false;
    }

    private boolean exists(int[][] grid, int sr, int er, int sc, int ec, int val) {
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                if (grid[i][j] == val) return true;
            }
        }
        return false;
    }

    private boolean canRemove(HashSet<Integer> set, int val,
                              int rows, int cols,
                              int[][] grid, int sr, int er, int sc, int ec) {

        if (set != null && !set.contains(val)) return false;

        if (rows > 1 && cols > 1) return true;

        if (rows == 1) {
            return grid[sr][sc] == val || grid[sr][ec] == val;
        }

        if (cols == 1) {
            return grid[sr][sc] == val || grid[er][sc] == val;
        }

        return false;
    }
}