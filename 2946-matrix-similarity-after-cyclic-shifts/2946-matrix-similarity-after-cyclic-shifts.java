class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;
        for (int i = 0; i < m; i++) {
            int shift = (i % 2 == 0) ? k : -k;
            for (int j = 0; j < n; j++) {
                int idx = (j + shift + n) % n;
                if (mat[i][j] != mat[i][idx]) return false;
            }
        }
        return true;
    }
}