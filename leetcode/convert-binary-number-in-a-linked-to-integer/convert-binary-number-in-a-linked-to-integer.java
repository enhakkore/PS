/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int value = 0;
        while(head != null){
            value = value << 1;
            value += head.val;
            head = head.next;
        }

        return value;
    }
}
