class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int j=n-1;
        while(j>=0 && s.charAt(j)==' ') j--;
        
        StringBuilder sb = new StringBuilder();
        while(j>=0){
            if(s.charAt(j)==' '){
                if(sb.length()>0){
                    ans.append(sb.reverse());
                    ans.append(" ");
                    sb.setLength(0);
                }
                j--;
            }else{
                sb.append(String.valueOf(s.charAt(j)));
                j--;
            }
            }
            ans.append(sb.reverse());
            
            return ans.toString().trim();
        }
    }