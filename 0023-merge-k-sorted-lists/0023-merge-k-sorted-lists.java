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
    public ListNode mergeKLists(ListNode[] lists) {
         List<Integer> allValues = new ArrayList<>();

        // Traverse each linked list
        for (ListNode head : lists) {
            while (head != null) {
                allValues.add(head.val);
                head = head.next;
            }
        }

        // Sort the collected values
        Collections.sort(allValues);

        // Create dummy node for result list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Create new nodes from sorted values
        for (int val : allValues) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}