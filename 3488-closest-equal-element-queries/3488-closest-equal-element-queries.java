class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // store indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(list, q);
            int size = list.size();

            int left = list.get((idx - 1 + size) % size);
            int right = list.get((idx + 1) % size);

            int d1 = Math.abs(q - left);
            d1 = Math.min(d1, n - d1);

            int d2 = Math.abs(q - right);
            d2 = Math.min(d2, n - d2);

            ans.add(Math.min(d1, d2));
        }

        return ans;
    }
}