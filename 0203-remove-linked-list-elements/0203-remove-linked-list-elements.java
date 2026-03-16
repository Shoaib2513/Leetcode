/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val!=val){
                dummy.next = temp;
                dummy = temp;
            }
            temp = temp.next;
        }
        dummy.next=null;
        return ans.next;
    }
}