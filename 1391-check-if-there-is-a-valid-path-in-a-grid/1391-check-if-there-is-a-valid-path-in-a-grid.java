class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        
        q.add(new int[]{0,0});
        vis[0][0] = true;
        
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            
            if(r == m-1 && c == n-1) return true;
            
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc]) continue;
                
                if(isValid(grid[r][c], grid[nr][nc], d)){
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        return false;
    }
    
    private boolean isValid(int a, int b, int[] d){
        int dr = d[0], dc = d[1];
        
        if(dr == 0 && dc == 1)
            return (a==1||a==4||a==6) && (b==1||b==3||b==5);
        
        if(dr == 0 && dc == -1)
            return (a==1||a==3||a==5) && (b==1||b==4||b==6);
        
        if(dr == 1 && dc == 0)
            return (a==2||a==3||a==4) && (b==2||b==5||b==6);
        
        if(dr == -1 && dc == 0)
            return (a==2||a==5||a==6) && (b==2||b==3||b==4);
        
        return false;
    }
}