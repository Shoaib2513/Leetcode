class Solution {
    public int hIndex(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int count=0;

        for(int i=n-1;i>=0;i--){
            if(arr[i]>count){
                count++;
            }
        }
     
        return count;
    }

}