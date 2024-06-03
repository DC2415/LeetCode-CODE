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
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head.next==null && n>=1){
//         return null;
//        }
       
//         ListNode temp=head;
//         int c=0;
//         while(temp!=null){
//             c++;
//             temp=temp.next;
//         }
//         int v=c-n;
//         int s=0;
//         ListNode temp1=head;
//         while(temp1!=null && temp1.next!=null){
//             s++;
//             if(s==v){
//                 temp1.next=temp1.next.next;
//             }
//             temp1=temp1.next;
//         }
//         return head;
//     }
// }
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        // Create a dummy node that points to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers - both start at the dummy node
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move the fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end of the list
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Slow pointer now points to the node before the one to be removed
        slow.next = slow.next.next;

        // Return the head of the modified list
        return dummy.next;
    }
}
