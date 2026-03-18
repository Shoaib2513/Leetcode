class Solution {
    public int helper(int n){
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        while(true){
            if(n==1) return true;
            if(n>9){
                if(map.containsKey(n)) return false;
                else map.put(n,1);
            } 
            int num = helper(n);
            n = num;
        }
    }
}