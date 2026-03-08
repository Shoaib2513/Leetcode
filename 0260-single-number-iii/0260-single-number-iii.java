class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],2);
            else map.put(nums[i],1);
        }

        int[] ans = new int[2];
        int k = 0;
        for(int key:map.keySet()){
            int freq = map.get(key);
            if(freq==1) ans[k++] = key;
        }
        return ans;
    }
}