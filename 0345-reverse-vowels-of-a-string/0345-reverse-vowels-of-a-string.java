class Solution {
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') return true;
        return false;
    }
    public String reverseVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int i=0,j=n-1;
        while(i<j){
            if(!isVowel(sb.charAt(i))) i++;
            else if(!isVowel(sb.charAt(j))) j--;
            else{
                char temp = sb.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                i++;j--;

            }
        }
        return sb.toString();
    }
}