class Solution {

    int MOD = 1000000007;
    int[][][] dp;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        dp = new int[zero + 1][one + 1][2];

        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        long ans = (dfs(zero, one, 0) + dfs(zero, one, 1)) % MOD;
        return (int) ans;
    }

    private int dfs(int z, int o, int last){

        if(z == 0 && o == 0) return 1;

        if(dp[z][o][last] != -1) return dp[z][o][last];

        long res = 0;

        if(last == 0){
            for(int k = 1; k <= Math.min(limit, z); k++){
                res = (res + dfs(z - k, o, 1)) % MOD;
            }
        } 
        else{
            for(int k = 1; k <= Math.min(limit, o); k++){
                res = (res + dfs(z, o - k, 0)) % MOD;
            }
        }

        return dp[z][o][last] = (int) res;
    }
}