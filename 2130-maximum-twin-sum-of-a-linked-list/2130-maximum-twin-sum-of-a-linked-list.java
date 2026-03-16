
class Solution {
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next= null;
        return newHead;
    }
    public int pairSum(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while(fast!=null){
        slow = slow.next;
        fast = fast.next.next;
      }         

      ListNode temp1 = head;
      ListNode temp2 = reverse(slow);
      int maxSum = Integer.MIN_VALUE;

      while(temp1!=slow){
        int sum = temp1.val+temp2.val;
        maxSum = Math.max(maxSum,sum);
        temp1 = temp1.next;
        temp2 = temp2.next;
      }
      return maxSum;
    }
}