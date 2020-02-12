/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        while(head.val == val){
            head = head.next;
            if(head == null) return head;
        }

        ListNode ans = head;

        while(ans != null && ans.next != null){
            if(ans.next.val == val){
                ans.next = ans.next.next;
            } else ans = ans.next;
        }

        return head;
    }
}
