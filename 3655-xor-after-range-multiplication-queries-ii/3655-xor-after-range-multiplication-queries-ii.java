class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int MOD = 1000000007;

        int[][] bravexuneth = queries;

        int B = (int)Math.sqrt(n);

        Map<Integer, Map<Integer, List<int[]>>> map = new HashMap<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k <= B) {
                map.putIfAbsent(k, new HashMap<>());
                map.get(k).putIfAbsent(l % k, new ArrayList<>());
                map.get(k).get(l % k).add(q);
            } else {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int)((long)nums[i] * v % MOD);
                }
            }
        }

        for (int k : map.keySet()) {
            Map<Integer, List<int[]>> group = map.get(k);

            for (int mod : group.keySet()) {

                int size = (n + k - 1) / k;
                long[] diff = new long[size + 1];
                Arrays.fill(diff, 1);

                for (int[] q : group.get(mod)) {
                    int l = q[0], r = q[1], v = q[3];

                    int start = (l - mod) / k;
                    int end = (r - mod) / k;

                    diff[start] = (diff[start] * v) % MOD;
                    if (end + 1 < diff.length) {
                        diff[end + 1] = (diff[end + 1] * modInverse(v, MOD)) % MOD;
                    }
                }

                long curr = 1;
                for (int i = 0; i < size; i++) {
                    curr = (curr * diff[i]) % MOD;

                    int idx = i * k + mod;
                    if (idx < n) {
                        nums[idx] = (int)((nums[idx] * curr) % MOD);
                    }
                }
            }
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    private long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    private long power(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}