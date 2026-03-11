class Solution {
    public String convertToBinary(int n){
        if(n==0) return "0";
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int rem= n%2;
            sb.append(Integer.toString(rem));
            n /= 2;
        }
        return sb.reverse().toString();
    }
    public int bitwiseComplement(int n) {
        String s = convertToBinary(n);
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1') sb.setCharAt(i,'0');
            else sb.setCharAt(i,'1');
        }
        int ans = 0;
        int i=sb.length()-1;
        int x = 1;
        while(i>=0){
            if(sb.charAt(i)=='1'){
                ans += x*1;
            }
            x *= 2;
            i--;
        }
        return ans;
    }
}