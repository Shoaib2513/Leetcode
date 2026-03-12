class Solution {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int n = nums.length;
      int diff = Integer.MAX_VALUE;
      int ans = 0;
      int k=0;
      while(k<n-2){
        int i=k+1;
        int j=n-1;
        while(i<j){
            int sum = nums[k]+nums[i]+nums[j];
            int x = Math.abs(sum-target);
            if(x<diff){
                diff = x;
                ans = sum;
            }
            diff = Math.min(x,diff);
            if(sum<target) i++;
            else j--;
        }
        k++;
      }
      return ans;

    }
}