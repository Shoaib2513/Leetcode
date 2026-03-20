class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        for(int i = 0; i <= m - k; i++){
            for(int j = 0; j <= n - k; j++){

                int size = k * k;

                if(size == 1){
                    ans[i][j] = 0;
                    continue;
                }

                int[] arr = new int[size];
                int idx = 0;

                for(int x = i; x < i + k; x++){
                    for(int y = j; y < j + k; y++){
                        arr[idx++] = grid[x][y];
                    }
                }

                Arrays.sort(arr);

                int minDiff = Integer.MAX_VALUE;

                for(int p = 1; p < size; p++){
                    if(arr[p] == arr[p-1]) continue;

                    minDiff = Math.min(minDiff, arr[p] - arr[p-1]);
                }
                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }

        return ans;
    }
}