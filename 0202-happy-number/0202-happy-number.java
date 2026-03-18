class Solution {
    public int helper(int n){
        String s = Integer.toString(n);
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i)-'0';
            sum += ch*ch;
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