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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode ans = new ListNode(0); 
        ListNode cur = ans;

        while (fast != null) {
            
            cur.next = slow;
            cur = cur.next;

          
            int gcdValue = gcd(slow.val, fast.val);

           
            ListNode gcdNode = new ListNode(gcdValue);
            cur.next = gcdNode;
            cur = cur.next;

           
            slow = fast;
            fast = fast.next;
        }

       
        cur.next = slow;

        
        return ans.next;
    }

   
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
