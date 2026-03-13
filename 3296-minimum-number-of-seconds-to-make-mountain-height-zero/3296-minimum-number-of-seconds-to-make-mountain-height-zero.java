class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long)1e18;

        while(left < right){
            long mid = left + (right - left) / 2;

            if(canReduce(mid, mountainHeight, workerTimes)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    boolean canReduce(long time, int height, int[] workers){

        long total = 0;

        for(int t : workers){

            long l = 0, r = height;

            while(l <= r){

                long mid = (l + r) / 2;

                long needed = (long)t * mid * (mid + 1) / 2;

                if(needed <= time){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }

            total += r;

            if(total >= height) return true;
        }

        return false;
    }
}