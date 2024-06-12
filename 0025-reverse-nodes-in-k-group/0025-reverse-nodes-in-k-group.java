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
    public ListNode reverseKGroup(ListNode head, int k) {
        // ListNode temp=head;
        // while(temp!=null){
        //     ListNode Knode= getKnode(temp,k);
        //     ListNode nextOfK=Knode.next;
        //     Knode.next=null;
        //     temp=reverse(temp);
        //     if(temp==head){
        //         head=Knode;
        //     }
        //     temp=nextOfK;
        // }
        // return head;
         if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode groupStart = head;

        while (groupStart != null) {
            ListNode groupEnd = getKnode(groupStart, k);
            if (groupEnd == null) {
                break; // Less than k nodes remain
            }
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null; // Detach the k-group
            prevGroupEnd.next = reverse(groupStart); // Reverse and attach the k-group
            groupStart.next = nextGroupStart; // Connect to the next part of the list

            // Move pointers to the next group
            prevGroupEnd = groupStart;
            groupStart = nextGroupStart;
        }

        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode getKnode(ListNode head, int k) {
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }
}