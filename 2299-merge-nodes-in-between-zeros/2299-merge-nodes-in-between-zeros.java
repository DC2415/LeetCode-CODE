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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp=head;
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        int sum=0;
        while(temp!=null){
            if(temp.val==0){
                //flag=0;
                cur.next=new ListNode(sum);
                cur=cur.next;
                sum=0;
            }
            else{
                sum+=temp.val;
            }
            temp=temp.next;

        }
        return ans.next.next;
    }
}