class Solution {
    public int helper(int[] arr,int k){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==k) list.add(i);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=list.size()-3;i++){
            int a = list.get(i);
            int b =list.get(i+1);
            int c = list.get(i+2);

            int val = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
            min = Math.min(val,min);
        }
        
        return min;
    }
    public int minimumDistance(int[] nums) {
      int n = nums.length;
      HashMap<Integer,Integer> map = new HashMap<>();
      int ans = Integer.MAX_VALUE;
      boolean flag = false;

      for(int i=0;i<n;i++){
        if(map.containsKey(nums[i])){
            int freq = map.get(nums[i]);
            map.put(nums[i],freq+1);
        }else{
            map.put(nums[i],1);
        }
      }

      for(int key:map.keySet()){
        int freq = map.get(key);
        if(freq>=3){
            int res = helper(nums,key);
            ans = Math.min(res,ans);
            flag = true;
        }
      } 
      if(flag==false) return -1;
      return ans; 
    }
}