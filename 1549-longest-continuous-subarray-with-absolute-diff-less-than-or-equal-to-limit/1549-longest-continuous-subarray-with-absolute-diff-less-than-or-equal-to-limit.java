class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<pair> minheap=new PriorityQueue<>((a,b)->a.val-b.val);
        PriorityQueue<pair> maxheap=new PriorityQueue<>((a,b)->b.val-a.val);
        int i=0,j=0,ans=0;
        while(j<nums.length){
            minheap.add(new pair(nums[j],j));
            maxheap.add(new pair(nums[j],j));
            while(maxheap.peek().val-minheap.peek().val >limit){
                 i=Math.min(maxheap.peek().ind, minheap.peek().ind)+1;
                while(maxheap.peek().ind<i){
                    pair a=maxheap.poll();
                }
                while(minheap.peek().ind<i){
                    pair a=minheap.poll();
                }
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
class pair{
    int val;
    int ind;
    public pair(int a, int b){
        val=a;
        ind =b;
    }
}