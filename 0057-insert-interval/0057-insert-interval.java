class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] in=new int[intervals.length+1][2];
        int i1=0;
        for(int[] a: intervals){
            in[i1++]=a;
        }
        in[i1]=newInterval;
        Arrays.sort(in,(a,b)->a[0]-b[0]);
        ArrayList<int[]> ds =new ArrayList();
        int start=in[0][0];
        int end=in[0][1];
        for(int i=1;i<in.length;i++){
            if(end>=in[i][0]){
                end=Math.max(end,in[i][1]);
            }else{    
                ds.add(new int[]{start,end});
                start=in[i][0];
                end=in[i][1];
            }
        }
        ds.add(new int[]{start,end});
        int[][] ans =new int[ds.size()][2];
        for(int i =0;i<ds.size();i++){
            ans[i]=ds.get(i);
        }
        return ans;
    }
}