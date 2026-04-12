class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[27][27];

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[26][26] = 0;

        for (int i = 0; i < n; i++) {
            int[][] newDp = new int[27][27];
            for (int a = 0; a < 27; a++) {
                for (int b = 0; b < 27; b++) {
                    newDp[a][b] = Integer.MAX_VALUE;
                }
            }

            int curr = word.charAt(i) - 'A';

            for (int f1 = 0; f1 < 27; f1++) {
                for (int f2 = 0; f2 < 27; f2++) {
                    int val = dp[f1][f2];
                    if (val == Integer.MAX_VALUE) continue;

                    int useF1 = val + dist(f1, curr);
                    newDp[curr][f2] = Math.min(newDp[curr][f2], useF1);

                    int useF2 = val + dist(f2, curr);
                    newDp[f1][curr] = Math.min(newDp[f1][curr], useF2);
                }
            }

            dp = newDp;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                res = Math.min(res, dp[i][j]);
            }
        }
        return res;
    }

    private int dist(int a, int b) {
        if (a == 26) return 0;
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}