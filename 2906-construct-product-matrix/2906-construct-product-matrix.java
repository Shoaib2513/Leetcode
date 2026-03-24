class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      int mod = 12345;

      int total = m*n;
      int[] flatten = new int[total];
      int k=0;

      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            flatten[k]=grid[i][j] % mod;
            k++;
        }
      }

      int[] pre = new int[total];
      pre[0] = 1;
      for(int i=1;i<pre.length;i++){
        pre[i] = (pre[i-1] * flatten[i-1]) % mod;
      }

      int[] suf = new int[total];
      suf[total-1] = 1;
      for(int j=suf.length-2;j>=0;j--){
        suf[j] = (suf[j+1] * flatten[j+1]) % mod;
      }  

      int[] res = new int[total];
      for(int i=0;i<total;i++){
        res[i] = (pre[i] * suf[i]) % mod;
      }

      int[][] ans = new int[m][n];
      k = 0;
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            ans[i][j] = res[k];
            k++;
        }
      }

      return ans;
    }
}