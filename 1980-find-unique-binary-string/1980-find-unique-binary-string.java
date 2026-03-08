class Solution {
    public void helper(ArrayList<String> res, int n,String ans){
        if(ans.length()==n){
            res.add(ans);
            return;
        }
        helper(res,n,ans+"0");
        helper(res,n,ans+"1");
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        ArrayList<String> res = new ArrayList<>();
        helper(res,n,"");
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
        }

        for(int i=0;i<res.size();i++){
            if(map.containsKey(res.get(i))) continue;
            else return res.get(i);
        }
        
        return "34";

    }
}