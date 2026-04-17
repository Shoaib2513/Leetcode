class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            Integer prev = map.get(nums[i]);
            if(prev != null) {
                ans = Math.min(ans, i - prev);
            }

            int x = nums[i], rev = 0;
            while(x > 0) {
                rev = rev * 10 + x % 10;
                x /= 10;
            }

            map.put(rev, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}