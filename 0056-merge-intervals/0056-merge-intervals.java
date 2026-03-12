class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        //sorted
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(intervals[i][0]>intervals[j][0]){
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int i=0;
        while(i<n){
            int j=i;
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(j<n-1 && end>=intervals[j+1][0]){
                end = Math.max(end,intervals[j+1][1]);
                  j++;
            }
        
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(start);
            arr.add(end);
            list.add(arr);
            i = j+1;
    
        }

        int num = list.size();
        int[][] result = new int[num][2];
        for(int k=0;k<list.size();k++){
            result[k][0] = list.get(k).get(0);
            result[k][1] = list.get(k).get(1);
        }
        return result;

    }
}