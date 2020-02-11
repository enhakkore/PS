/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode answer, ans;
        answer = ans = new ListNode(0);

        while(true){
            if(l1 == null && l2 == null) break;

            int tmp1, tmp2;
            tmp1 = tmp2 = Integer.MAX_VALUE;
            if(l1 != null) tmp1 = l1.val;
            if(l2 != null) tmp2 = l2.val;

            if( tmp1 >= tmp2 ){
                ans.next = new ListNode(tmp2);
                ans = ans.next;
                l2 = l2.next;
            } else {
                ans.next = new ListNode(tmp1);
                ans = ans.next;
                l1 = l1.next;
            }

        }

        return answer.next;
    }
}
