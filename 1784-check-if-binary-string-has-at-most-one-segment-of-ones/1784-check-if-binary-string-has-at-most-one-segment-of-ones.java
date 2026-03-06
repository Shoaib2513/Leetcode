class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean zeroFound = false;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                zeroFound = true;
            }
            if(s.charAt(i)=='1' && zeroFound==true) return false;
        }
        return true;
    }
}