class Solution {
    public int helper(String s){
        int n = s.length();
        if(n==1) return s.charAt(0)-'0';
        int i=0;
        int sum = 0;
        while(i<n){
            sum += s.charAt(i)-'0';
            i++;
        }
        return helper(Integer.toString(sum));
    }
    public int addDigits(int num) {
        return helper(Integer.toString(num));
    }
}