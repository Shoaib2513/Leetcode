class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            n++;
        }

        temp = head;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = temp.val;
            temp = temp.next;
        }

        int[] ans = {-1, -1};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < n - 1; i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) list.add(i);
            if(arr[i] < arr[i-1] && arr[i] < arr[i+1]) list.add(i);
        }
        if(list.size() < 2) return ans;
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            int diff = list.get(i) - list.get(i-1);
            res = Math.min(diff, res);
        }
        int mx = list.get(list.size()-1) - list.get(0);
        ans[0] = res;
        ans[1] = mx;
        return ans;
    }
}