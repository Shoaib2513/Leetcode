
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        int n = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            n++;
        }
         
        int[] arr = new int[n];
        temp = head;
        int i =0;
        while(temp!=null){
            int x = temp.val;
            temp = temp.next;
            arr[i++]=x;
        }

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
         i=0;
        while(i<n){
            ListNode a = new ListNode(arr[i]);
            t.next = a;
            t = t.next;
            i+=2;
        }
        i=1;
        while(i<n){
            ListNode a = new ListNode(arr[i]);
            t.next = a;
            t = t.next;
            i+=2;
        }

        return dummy.next;

        
    }
}