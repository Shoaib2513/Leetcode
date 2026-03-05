class Solution {
    public int minOperations(String s) {
        int count = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) != (char)((i % 2) + '0')){
                count++;
            }
        }

        return Math.min(count, n - count);
    }
}