

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] arr = new long[n];
        
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) arr[i] = x;
            else if (x == side) arr[i] = side + y;
            else if (y == side) arr[i] = 2L * side + (side - x);
            else arr[i] = 3L * side + (side - y);
        }
        
        Arrays.sort(arr);
        
        long per = 4L * side;
        long[] ext = new long[2 * n];
        for (int i = 0; i < n; i++) {
            ext[i] = arr[i];
            ext[i + n] = arr[i] + per;
        }
        
        long lo = 0, hi = per, ans = 0;
        
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (can(ext, n, k, mid, per)) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        
        return (int) ans;
    }
    
    private boolean can(long[] ext, int n, int k, long d, long per) {
        for (int i = 0; i < n; i++) {
            int count = 1;
            long first = ext[i];
            long last = ext[i];
            int idx = i;
            
            while (true) {
                int next = lowerBound(ext, idx + 1, i + n, last + d);
                if (next == i + n) break;
                
                count++;
                last = ext[next];
                idx = next;
                
                if (count == k) {
                    if (Math.min(last - first, per - (last - first)) >= d)
                        return true;
                    break;
                }
            }
        }
        return false;
    }
    
    private int lowerBound(long[] arr, int l, int r, long target) {
        int ans = r;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (mid < arr.length && arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }
}