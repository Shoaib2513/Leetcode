class Solution {
    
    public long[] helper(int[][] arr, int i, int j, long[][][] dp) {
        int m = arr.length;
        int n = arr[0].length;
      
        if(i == m-1 && j == n-1){
            return new long[]{arr[i][j], arr[i][j]};
        }
        if(dp[i][j][0] != Long.MIN_VALUE){
            return new long[]{dp[i][j][0], dp[i][j][1]};
        }  
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        if(j + 1 < n){
            long[] right = helper(arr, i, j+1, dp);
            long a = arr[i][j] * right[0];
            long b = arr[i][j] * right[1]; 
            max = Math.max(max, Math.max(a, b));
            min = Math.min(min, Math.min(a, b));
        }
        if(i + 1 < m){
            long[] down = helper(arr, i+1, j, dp);
            long a = arr[i][j] * down[0];
            long b = arr[i][j] * down[1]; 
            max = Math.max(max, Math.max(a, b));
            min = Math.min(min, Math.min(a, b));
        }
        dp[i][j][0] = max;
        dp[i][j][1] = min; 
        return new long[]{max, min};
    }
    
    public int maxProductPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length; 
        long[][][] dp = new long[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j][0] = Long.MIN_VALUE;
                dp[i][j][1] = Long.MAX_VALUE;
            }
        }
        long[] res = helper(arr, 0, 0, dp);
        if(res[0] < 0) return -1;
        return (int)(res[0] % 1000000007);
    }
}