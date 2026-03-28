class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(i, j, parent);
                }
            }
        }

        char[] res = new char[n];
        char ch = 'a';

        for (int i = 0; i < n; i++) {
            int p = find(i, parent);
            if (res[p] == 0) {
                if (ch > 'z') return "";
                res[p] = ch++;
            }
            res[i] = res[p];
        }

        int[][] calc = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    if (i == n - 1 || j == n - 1) {
                        calc[i][j] = 1;
                    } else {
                        calc[i][j] = 1 + calc[i + 1][j + 1];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (calc[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(res);
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int a, int b, int[] parent) {
        int pa = find(a, parent);
        int pb = find(b, parent);
        if (pa != pb) parent[pa] = pb;
    }
}