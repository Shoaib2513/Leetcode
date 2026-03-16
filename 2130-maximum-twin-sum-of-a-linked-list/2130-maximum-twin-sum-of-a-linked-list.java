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
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();

        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }
        int maxSum = Integer.MIN_VALUE;

        int n = arr.size();
        int i=0,j=n-1;
        while(i<j){
            int sum = arr.get(i)+arr.get(j);
            maxSum = Math.max(maxSum,sum);
            i++;j--;
        }
        return maxSum;
    }
}