class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        HashMap<Integer,Integer> bottomMap = new HashMap<>();
        HashMap<Integer,Integer> topMap = new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total += grid[i][j];
                bottomMap.put(grid[i][j], bottomMap.getOrDefault(grid[i][j],0)+1);
            }
        }

        long sum = 0;

        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                int val = grid[i][j];
                sum += val;

                topMap.put(val, topMap.getOrDefault(val,0)+1);
                bottomMap.put(val, bottomMap.get(val)-1);
                if(bottomMap.get(val)==0) bottomMap.remove(val);
            }

            long other = total - sum;
            if(sum == other) return true;

            long diff = Math.abs(sum - other);
            if(diff > 100000) continue;

            if(sum > other){
                if(canRemove(topMap, (int)diff, i+1, n, grid, 0, i, 0, n-1)) return true;
            } else {
                if(canRemove(bottomMap, (int)diff, m-(i+1), n, grid, i+1, m-1, 0, n-1)) return true;
            }
        }

        bottomMap.clear();
        topMap.clear();
        total = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total += grid[i][j];
                bottomMap.put(grid[i][j], bottomMap.getOrDefault(grid[i][j],0)+1);
            }
        }

        sum = 0;

        for(int j=0;j<n-1;j++){
            for(int i=0;i<m;i++){
                int val = grid[i][j];
                sum += val;

                topMap.put(val, topMap.getOrDefault(val,0)+1);
                bottomMap.put(val, bottomMap.get(val)-1);
                if(bottomMap.get(val)==0) bottomMap.remove(val);
            }

            long other = total - sum;
            if(sum == other) return true;

            long diff = Math.abs(sum - other);
            if(diff > 100000) continue;

            if(sum > other){
                if(canRemove(topMap, (int)diff, m, j+1, grid, 0, m-1, 0, j)) return true;
            } else {
                if(canRemove(bottomMap, (int)diff, m, n-(j+1), grid, 0, m-1, j+1, n-1)) return true;
            }
        }

        return false;
    }

    private boolean canRemove(HashMap<Integer,Integer> map, int val,
                              int rows, int cols,
                              int[][] grid, int sr, int er, int sc, int ec) {

        if(!map.containsKey(val)) return false;

        if(rows > 1 && cols > 1) return true;

        if(rows == 1){
            if(grid[sr][sc] == val) return true;
            if(grid[sr][ec] == val) return true;
            return false;
        }

        if(cols == 1){
            if(grid[sr][sc] == val) return true;
            if(grid[er][sc] == val) return true;
            return false;
        }

        return false;
    }
}