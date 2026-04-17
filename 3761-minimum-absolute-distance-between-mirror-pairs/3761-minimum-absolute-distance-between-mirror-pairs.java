class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ans = Math.min(ans, i - map.get(nums[i]));
            }

            int rev = 0;
            int x = nums[i];

            while(x > 0) {
                rev = rev * 10 + x % 10;
                x /= 10;
            }

            map.put(rev, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}