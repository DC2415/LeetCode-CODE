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
     public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Find the length of the list and the last node
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        // Connect the last node to the head to form a circular list
        temp.next = head;

        // Compute the effective rotations needed
        k = k % length;
        int stepsToNewHead = length - k;

        // Find the new end of the list
        ListNode newEnd = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newEnd = newEnd.next;
        }

        // Set the new head and break the circular list
        ListNode newHead = newEnd.next;
        newEnd.next = null;

        return newHead;
    }
   
}