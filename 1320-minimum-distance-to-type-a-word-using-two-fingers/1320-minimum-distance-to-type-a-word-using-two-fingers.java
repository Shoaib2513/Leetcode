class Solution {
    int[][][] dp;

    public int minimumDistance(String word) {
        int n = word.length();
        dp = new int[27][27][n];
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(word, 26, 26, 0);
    }

    private int solve(String word, int f1, int f2, int idx) {
        if (idx == word.length()) return 0;

        if (dp[f1][f2][idx] != -1) return dp[f1][f2][idx];

        int curr = word.charAt(idx) - 'A';

        int useF1 = dist(f1, curr) + solve(word, curr, f2, idx + 1);
        int useF2 = dist(f2, curr) + solve(word, f1, curr, idx + 1);

        return dp[f1][f2][idx] = Math.min(useF1, useF2);
    }

    private int dist(int a, int b) {
        if (a == 26) return 0;
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}