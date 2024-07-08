class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> ds=new LinkedList<>();
        int i=1;
        while(i<=n){
            ds.add(i);
            i++;
        }
        while(ds.size()>1){
            int j=1;
            while(j<k){
                int a=ds.poll();
                ds.add(a);
                j++;
            }
          ds.poll();
        }
        return ds.peek();
    }
}