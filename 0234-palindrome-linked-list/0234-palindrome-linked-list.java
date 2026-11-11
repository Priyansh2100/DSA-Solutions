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
    public boolean isPalindrome(ListNode head) {

        //Base Conditions
        if(head == null && head.next==null){
            return true;
        }

        //Find the med element
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the linkedlist from mid to last
        ListNode curr = slow.next;
        ListNode prev = null;
        while(curr!= null){
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }

        //check the val now
        ListNode onenode = prev;
        ListNode secondnode = head;
        while(onenode!= null){
            if(onenode.val!=secondnode.val){
                return false;
            }
            onenode = onenode.next;
            secondnode = secondnode.next;
        }
        return true;

        
    }
}