class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans =new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int as=arr[queries[i][0]];
            for(int j=queries[i][0]+1;j<=queries[i][1];j++){
                as=as^arr[j];
            }
            ans[i]=as;
        }
        return ans;
    }
}