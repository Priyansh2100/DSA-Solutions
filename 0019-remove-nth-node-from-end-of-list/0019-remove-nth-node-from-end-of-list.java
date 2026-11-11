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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int count = 0;

        while(temp!=null) {
            temp = temp.next;
            count++;
        }

        int removeNodeidx = count - n -1;

        // If head itself needs to be removed
        if (count == n) {
            return head.next;
        }

        temp = head;
        int i =0;

        while (i<removeNodeidx){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;

        return head;
        
    }
}