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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet();
        for(int a : nums){
            set.add(a);
        }
          ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pre = dum, current = head;

        while (current != null) {
            if (set.contains(current.val)) {
                pre.next = current.next; 
            } else {
                pre = current; 
            }
            current = current.next; 
        }

        return dum.next;
    }
}