class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] arr = new int[m][n];
        int[][] countX = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='X') arr[i][j]=1;
                else if(grid[i][j]=='Y') arr[i][j]=-1;
                else arr[i][j]=0;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val = arr[i][j];
                int x = (grid[i][j] == 'X') ? 1 : 0;

                int up = (i>0) ? arr[i-1][j] : 0;
                int left = (j>0) ? arr[i][j-1] : 0;
                int diag = (i>0 && j>0) ? arr[i-1][j-1] : 0;

                arr[i][j] = val + up + left - diag;

                int upX = (i>0) ? countX[i-1][j] : 0;
                int leftX = (j>0) ? countX[i][j-1] : 0;
                int diagX = (i>0 && j>0) ? countX[i-1][j-1] : 0;

                countX[i][j] = x + upX + leftX - diagX;
            }
        }

        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 0 && countX[i][j] > 0){
                    count++;
                }
            }
        }

        return count;
    }
}