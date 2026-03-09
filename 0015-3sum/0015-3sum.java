class Solution {
     public ArrayList<Integer> binaryWork(int[] nums,int target,int low,int a,int b){
        int lo = low;
        int hi = nums.length-1;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(a); res.add(b);
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]==target){
                res.add(nums[mid]);
                return res;
            }
            else if(nums[mid]<target) lo = mid+1;
            else if(nums[mid]>target) hi = mid-1; 
        }
        return null;
    }
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(nums);
       int n = nums.length;
       for(int i=0;i<n-2;i++){
        if(i>0 && nums[i]==nums[i-1]) continue;
        for(int j=i+1;j<n-1;j++){
            int target = -nums[i]-nums[j];
            if(j>i+1 && nums[j]==nums[j-1]) continue;
            ArrayList<Integer> temp = binaryWork(nums,target,j+1,nums[i],nums[j]);
            if(temp!=null){
                ans.add(temp);
            }
        }
       }

       return ans; 
    }
}