class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];
        
        int k = 0;
        int rem = grid[0][0] % x;
        
        for (int[] row : grid) {
            for (int num : row) {
                if (num % x != rem) return -1;
                arr[k++] = num;
            }
        }
        
        java.util.Arrays.sort(arr);
        int median = arr[size / 2];
        
        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }
        
        return operations;
    }
}