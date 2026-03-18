class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[] colSum = new int[n];
        int count = 0;

        for(int i = 0; i < m; i++){
            int rowSum = 0;

            for(int j = 0; j < n; j++){
                colSum[j] += grid[i][j];
                rowSum += colSum[j];

                if(rowSum <= k){
                    count++;
                }
            }
        }

        return count;
    }
}