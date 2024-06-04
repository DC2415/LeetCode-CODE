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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode temp = head;
        ArrayList<Integer> q = new ArrayList<>();
        
        while(temp != null){
            q.add(temp.val);
            temp = temp.next;
        }
        
        Collections.sort(q);
        
        // Reset temp to the head of the list
        temp = head;
        int i = 0;
        
        while(temp != null){
            temp.val = q.get(i++);
            temp = temp.next;
        }
        
        return head;
    }
}
