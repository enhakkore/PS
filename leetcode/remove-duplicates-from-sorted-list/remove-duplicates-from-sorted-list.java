/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = head;

        while(ans != null && ans.next != null){
            if(ans.val == ans.next.val)
                ans.next = ans.next.next;
            else ans = ans.next;
        }

        return head;
    }
}
