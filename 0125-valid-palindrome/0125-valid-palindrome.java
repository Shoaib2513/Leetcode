class Solution {
    public boolean helper(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(ch1!=ch2) return false;
            i++;j--;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int ascii = (int)ch;
            if(ascii>=97 && ascii<=122){
                sb.append(ch);
            }else if(ascii>=65 && ascii<=90){
                ascii += 32;
                ch = (char)ascii;
                sb.append(ch);
            }else if(ascii>=48 && ascii<=57){
                sb.append(ascii-48);
            }else continue;
        }
        String str = sb.toString();
        return helper(str);
    }
}