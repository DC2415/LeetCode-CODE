class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int a:nums){
            minheap.add(a);
            if(minheap.size()>k){
                int s=minheap.poll();
            }
        }
        return minheap.peek();
    }
}