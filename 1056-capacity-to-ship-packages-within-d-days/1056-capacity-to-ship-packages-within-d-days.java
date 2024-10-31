class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        for(int i:weights){
           low =Math.max(low,i);
        }
        int high=sum(weights);
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int c=check(weights,mid);

            if(c>days){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public int sum(int[]w){
        int sum=0;
        for(int a:w){
            sum+=a;
        }
        return sum;
    }
    public int check(int[]w, int mid){
        int we=0,day=1;
        for(int i=0;i<w.length;i++){
            if(we+w[i]<=mid){
                we+=w[i];
            }else{
                we=w[i];
                day+=1;
            }
        }
        return day;
    }
}