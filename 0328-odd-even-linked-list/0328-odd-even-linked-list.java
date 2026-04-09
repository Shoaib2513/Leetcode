class Solution {
    public int size(ListNode head){
        ListNode t = head;
        int n = 0;
        while(t!=null){
            n++;
            t = t.next;
        }
        return n;
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;
        int n = size(head);

        ListNode odd = head;
        ListNode even = head.next;

        ListNode t1 = odd;
        ListNode t2 = even;
        
        if(n%2==1){
              while(t1!=null && t2!=null){
                t1.next = t1.next.next;
                t1 = t1.next;

                t2.next = t2.next.next;
                t2 = t2.next;
        }
        t1.next = even;
        }else{
              while(t1!=null && t2!=null){
                t1.next = t1.next.next;
                t1 = t1.next;

                t2.next = t2.next.next;
                t2 = t2.next;
                if(t2.next==null) break;
        }
        t1.next = even;
        }
        return odd;

    }
}