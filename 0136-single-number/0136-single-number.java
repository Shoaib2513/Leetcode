class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int el:nums){
            ans ^= el;
        }
        return ans;
    }
}