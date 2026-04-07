class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
      
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
          ListNode next = curr.next;
          boolean isDuplicate = false;
          if(prev!=null && prev.val==curr.val){
            isDuplicate = true;
          }
          if(next!=null && curr.val==next.val){
            isDuplicate = true;
          }
          
          if(isDuplicate==false){
            temp.next=curr;
            temp = curr;
          }
          prev = curr;
          curr = next;

        }
        temp.next = null;

        return dummy.next;
    }
}