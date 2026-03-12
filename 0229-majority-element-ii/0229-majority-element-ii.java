class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n= nums.length;
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int freq = map.get(nums[i]);
                map.put(nums[i],freq+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int i=0;
        while(i<n){
            int j=i;
            int freq = map.get(nums[i]);
            if(freq>(n/3)) ans.add(nums[i]);
            while(j<n && nums[i]==nums[j]) j++;
            i = j;
    

        }
        return ans;
    }
}