class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        List<Integer>[] map = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            map[nums[i]].add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            List<Integer> list = map[i];
            if (list.size() < 3) continue;

            for (int j = 0; j + 2 < list.size(); j++) {
                int p = list.get(j);
                int r = list.get(j + 2);
                ans = Math.min(ans, 2 * (r - p));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}