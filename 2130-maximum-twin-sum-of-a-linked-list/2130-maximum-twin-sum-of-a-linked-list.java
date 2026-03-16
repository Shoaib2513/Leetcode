class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode Next = null;
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode temp1 = head;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        ListNode temp = head;
        while(temp!=null){
            dummy.next = new ListNode(temp.val);
            dummy = dummy.next;
            temp = temp.next;
        }
        ans = ans.next;

        ListNode temp2 = reverse(ans);
        int maxSum = Integer.MIN_VALUE;

        while(temp1!=null && temp2!=null){
            int sum = temp1.val + temp2.val;
            maxSum = Math.max(maxSum,sum);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return maxSum;
    }
}