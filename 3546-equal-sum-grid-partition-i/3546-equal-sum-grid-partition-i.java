class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long totalSum = 0;

        long[] rowSum = new long[m];
        long[] colSum = new long[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
                totalSum += grid[i][j];
            }
        }
        long currSum = 0;
        for(int i = 0; i < m - 1; i++){
            currSum += rowSum[i];
            if(currSum == totalSum - currSum){
                return true;
            }
        }
        currSum = 0;
        for(int j = 0; j < n - 1; j++){
            currSum += colSum[j];
            if(currSum == totalSum - currSum){
                return true;
            }
        }

        return false;
    }
}