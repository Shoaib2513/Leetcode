class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 12345;

        int[][] ans = new int[m][n];
        int prefix = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = prefix;
                prefix = (prefix * (grid[i][j] % mod)) % mod;
            }
        }
        int suffix = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                ans[i][j] = (ans[i][j] * suffix) % mod;
                suffix = (suffix * (grid[i][j] % mod)) % mod;
            }
        }

        return ans;
    }
}