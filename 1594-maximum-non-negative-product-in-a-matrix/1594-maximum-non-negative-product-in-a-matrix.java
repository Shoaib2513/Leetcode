class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] maxDp = new long[n];
        long[] minDp = new long[n];
        maxDp[0] = grid[0][0];
        minDp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            maxDp[j] = maxDp[j - 1] * grid[0][j];
            minDp[j] = maxDp[j];
        }
        for (int i = 1; i < m; i++) {
            maxDp[0] = maxDp[0] * grid[i][0];
            minDp[0] = maxDp[0];
            for (int j = 1; j < n; j++) {
                long a = maxDp[j] * grid[i][j];    
                long b = minDp[j] * grid[i][j];
                long c = maxDp[j - 1] * grid[i][j];
                long d = minDp[j - 1] * grid[i][j];
                long newMax = Math.max(Math.max(a, b), Math.max(c, d));
                long newMin = Math.min(Math.min(a, b), Math.min(c, d));
                maxDp[j] = newMax;
                minDp[j] = newMin;
            }
        }
        long res = maxDp[n - 1];
        if (res < 0) return -1;
        return (int) (res % 1000000007);
    }
}