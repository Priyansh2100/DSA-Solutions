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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(0);     // STEP - 1 
        dummy.next = head;                    

        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null) {

            // Check whether current value is duplicated
            if (fast.next != null && fast.val == fast.next.val) {

                int duplicate = fast.val;

                // Skip all occurrences of this value
                while (fast != null && fast.val == duplicate) {
                    fast = fast.next;
                }

                slow.next = fast;
            }
            else {
                slow = fast;
                fast = fast.next;
            }
        }

        return dummy.next;
    }
}