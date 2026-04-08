class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        for(int[] q : queries){
            int li = q[0], ri = q[1], ki = q[2], vi = q[3];
            int idx = li;
            while(idx <= ri){
                nums[idx] = (int)((long)nums[idx] * vi % mod);
                idx += ki;
            }
        }
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }
}