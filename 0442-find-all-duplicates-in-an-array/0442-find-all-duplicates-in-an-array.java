class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int freq = map.get(nums[i]);
                map.put(nums[i],freq+1);
            }else{
                map.put(nums[i],1);
            }
        }

        ArrayList<Integer> arr =new ArrayList<>();
        for(int el:map.keySet()){
            int freq = map.get(el);
            if(freq==2){
                arr.add(el);
            }
        }
        return arr;
    }
}