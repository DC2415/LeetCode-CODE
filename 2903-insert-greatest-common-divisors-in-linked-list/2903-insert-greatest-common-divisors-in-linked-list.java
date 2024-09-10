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
        ListNode ans = new ListNode(0); // Dummy node
        ListNode cur = ans;

        while (fast != null) {
            
            cur.next = slow;
            cur = cur.next;

          
            int gcdValue = gcd(slow.val, fast.val);

            // Insert the GCD node between slow and fast
            ListNode gcdNode = new ListNode(gcdValue);
            cur.next = gcdNode;
            cur = cur.next;

            // Move the slow and fast pointers forward
            slow = fast;
            fast = fast.next;
        }

        // Attach the last node
        cur.next = slow;

        // Return the next node of the dummy node (which is the head of the new list)
        return ans.next;
    }

    // Function to calculate GCD
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b); // Return the recursive result
    }
}
