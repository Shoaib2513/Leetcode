class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            long mul = 1;
            for(int[] q : queries){
                int li = q[0], ri = q[1], ki = q[2], vi = q[3];
                if(i >= li && i <= ri && (i - li) % ki == 0){
                    mul = (mul * vi) % mod;
                }
            }
            nums[i] = (int)((nums[i] * mul) % mod);
        }
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }
}