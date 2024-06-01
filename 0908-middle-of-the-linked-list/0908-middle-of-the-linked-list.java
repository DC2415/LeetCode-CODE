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
    // brute force 

    // public ListNode middleNode(ListNode head) {
    //     int c=0;
    //     ListNode temp=head;
    //     while(temp !=null){
    //         c++;
    //         temp=temp.next;
    //     }
    //     int mid=(c/2)+1;
    //     System.out.print(mid);
        
    //     while(mid>1 && head !=null){
    //         mid--;
    //         head=head.next;
    //     }
    //     return head;
    // }

    // optimal 
     public ListNode middleNode(ListNode head) {
        
        ListNode fast =head;
        ListNode slow= head;
        while(fast!=null && fast.next!=null && slow!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}