class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][] prev = new int[n][3];
        int[][] curr = new int[n][3];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < 3; k++) {
                prev[j][k] = Integer.MIN_VALUE;
            }
        }
        prev[0][0] = coins[0][0];
        if (coins[0][0] < 0) prev[0][1] = 0;
        for (int j = 1; j < n; j++) {
            for (int k = 0; k < 3; k++) {
                if (prev[j - 1][k] != Integer.MIN_VALUE) {
                    prev[j][k] = prev[j - 1][k] + coins[0][j];
                }
                if (coins[0][j] < 0 && k > 0 && prev[j - 1][k - 1] != Integer.MIN_VALUE) {
                    prev[j][k] = Math.max(prev[j][k], prev[j - 1][k - 1]);
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int k = 0; k < 3; k++) {
                curr[0][k] = Integer.MIN_VALUE;

                if (prev[0][k] != Integer.MIN_VALUE) {
                    curr[0][k] = prev[0][k] + coins[i][0];
                }

                if (coins[i][0] < 0 && k > 0 && prev[0][k - 1] != Integer.MIN_VALUE) {
                    curr[0][k] = Math.max(curr[0][k], prev[0][k - 1]);
                }
            }
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    int best = Math.max(prev[j][k], curr[j - 1][k]);
                    if (best != Integer.MIN_VALUE) {
                        curr[j][k] = best + coins[i][j];
                    } else {
                        curr[j][k] = Integer.MIN_VALUE;
                    }
                    if (coins[i][j] < 0 && k > 0) {
                        int alt = Math.max(prev[j][k - 1], curr[j - 1][k - 1]);
                        if (alt != Integer.MIN_VALUE) {
                            curr[j][k] = Math.max(curr[j][k], alt);
                        }
                    }
                }
            }
            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }
        return Math.max(prev[n - 1][0],
               Math.max(prev[n - 1][1], prev[n - 1][2]));
    }
}