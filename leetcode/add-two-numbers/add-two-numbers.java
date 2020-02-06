/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode answer = ans;
        int num1, num2, num3 = 0;

        while(true){
            int tmp = num3;
            if(l1 != null){
                num1 = l1.val;
            } else num1 = 0;

            if(l2 != null){
                num2 = l2.val;
            } else num2 = 0;

            tmp += num1 + num2;
            if(tmp > 9){
                num3 = 1;
                tmp %= 10;
            }
            else num3 = 0;

            ListNode tmpN = new ListNode(tmp);
            ans.next = tmpN;
            ans = tmpN;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            if(l1 == null && l2 == null){
                if(num3 != 0){
                    ListNode last = new ListNode(num3);
                    ans.next = last;
                }
                break;
            }
        }

        return answer.next;
    }
}
