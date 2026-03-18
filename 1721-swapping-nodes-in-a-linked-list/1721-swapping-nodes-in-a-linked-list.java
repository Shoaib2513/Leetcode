
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            temp = temp.next;
            n++;
        }
        ListNode temp1 = head;
        ListNode temp2 = head;
        int count=1;
        while(count<k){
            temp1 = temp1.next;
            count++;
        }
        count=1;
        while(count<n-k+1){
            temp2 = temp2.next;
            count++;
        }
        int t = temp1.val;
        temp1.val = temp2.val;
        temp2.val = t;
        return head;
    }
}