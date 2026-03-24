class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        pre[0] = nums[0];
        suf[nums.length-1]= nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            pre[i] = nums[i]*pre[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            suf[i] = nums[i]*suf[i+1];
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                nums[i] = suf[i+1];
            }else if(i==nums.length-1){
                nums[i] = pre[i-1];
            }else{
                nums[i] = pre[i-1]*suf[i+1];
            }
        }
        return nums;

    }
}