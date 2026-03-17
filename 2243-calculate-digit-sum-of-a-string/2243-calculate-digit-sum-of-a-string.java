class Solution {
    public String helper(String s,int k){
        if(s.length()<=k) return s;
        StringBuilder sb = new StringBuilder();
        int n=s.length();
        int i = 0;
        while(i<n){
            int count=0;
            int j=i;
            int sum=0;
            while(j<n && count<k){
                sum += Integer.parseInt(String.valueOf(s.charAt(j)));
                count++;
                j++;
            }
            sb.append(sum);
            i=j;
        }
        return helper(sb.toString(),k);
    }
    public String digitSum(String s, int k) {
        return helper(s,k);
    }
}