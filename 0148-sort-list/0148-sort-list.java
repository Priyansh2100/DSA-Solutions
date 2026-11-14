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
    public ListNode sortList(ListNode head) {
        
        ListNode temp = head;

        if(head == null || head.next == null) return head;

        ArrayList<Integer> arr = new ArrayList<>();

        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(100);

        ListNode temp1 =dummy;

        Collections.sort(arr);

        for(int i =0;i<arr.size();i++){
            dummy.next = new ListNode(arr.get(i));
            dummy = dummy.next;
        }

        return temp1.next;
    }
}