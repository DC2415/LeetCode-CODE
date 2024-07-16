class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ds=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }else{    
                ds.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
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