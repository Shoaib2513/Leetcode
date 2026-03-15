class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int freq = map.get(nums[i]);
                map.put(nums[i],freq+1);
            }
            else map.put(nums[i],1);
        }

        for(int i=1;i<=n;i++){
            if(map.containsKey(i)) continue;
            else arr.add(i);
        }
        return arr;
    }
}