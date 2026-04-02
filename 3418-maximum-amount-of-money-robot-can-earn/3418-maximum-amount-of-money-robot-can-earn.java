class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        for (int k = 0; k < 3; k++) {
            dp[0][0][k] = Integer.MIN_VALUE;
        }

        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {

                    int fromUp = Integer.MIN_VALUE;
                    int fromLeft = Integer.MIN_VALUE;

                    if (i > 0) fromUp = dp[i - 1][j][k];
                    if (j > 0) fromLeft = dp[i][j - 1][k];

                    int best = Math.max(fromUp, fromLeft);

                    if (best != Integer.MIN_VALUE) {
                        dp[i][j][k] = best + coins[i][j];
                    } else {
                        dp[i][j][k] = Integer.MIN_VALUE;
                    }

                    if (coins[i][j] < 0 && k > 0) {
                        int up = Integer.MIN_VALUE;
                        int left = Integer.MIN_VALUE;

                        if (i > 0) up = dp[i - 1][j][k - 1];
                        if (j > 0) left = dp[i][j - 1][k - 1];

                        int prevBest = Math.max(up, left);

                        if (prevBest != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], prevBest);
                        }
                    }
                }
            }
        }
        int ans = dp[m - 1][n - 1][0];
        ans = Math.max(ans, dp[m - 1][n - 1][1]);
        ans = Math.max(ans, dp[m - 1][n - 1][2]);
        return ans;
    }
}