/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    // native approch
    
    // public ListNode detectCycle(ListNode head) {
    //     ListNode temp=head;
    //     HashMap<ListNode ,Integer> vis=new HashMap<>();
    //     while(temp!=null){
    //         if(vis.containsKey(temp)){
    //             return temp;
    //         }
    //         vis.put(temp,1);
    //         temp=temp.next;
    //     }
    //     return null;
    // }
    
    // optimal

    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}