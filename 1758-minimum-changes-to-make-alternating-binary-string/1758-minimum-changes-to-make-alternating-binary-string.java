class Solution {
    public int operationOne(String s){
        int count = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(i%2==0){
                if(s.charAt(i)=='0') count++;
            }else{
                if(s.charAt(i)=='1') count++;
            }
        }
        return count;
    }
    public int operationZero(String s){
        int count=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(i%2==0){
                if(s.charAt(i)=='1') count++;
            }else{
                if(s.charAt(i)=='0') count++;
            }
        }
        return count;
    }
    public int minOperations(String s) {
        int count1 = operationOne(s);
        int count2 = operationZero(s);
        return Math.min(count1,count2);
    }
}