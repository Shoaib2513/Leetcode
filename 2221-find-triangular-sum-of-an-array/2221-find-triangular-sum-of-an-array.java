class Solution {
    public int helper(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp = new int[n-1];
        for(int i=0;i<n-1;i++){
            temp[i] = nums[i]+nums[i+1];
            temp[i] %= 10;
        }
        return helper(temp);
    }
    public int triangularSum(int[] nums) {
        return helper(nums);
    }
}