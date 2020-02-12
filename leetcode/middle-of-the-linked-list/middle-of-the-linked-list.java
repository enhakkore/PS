/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] info = new ListNode[100];

        int count = 0;
        while(head != null){
            info[count++] = head;
            head = head.next;
        }

        return info[count/2];
    }
}
