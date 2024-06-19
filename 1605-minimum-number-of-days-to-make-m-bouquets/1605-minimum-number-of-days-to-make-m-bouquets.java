class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=minim(bloomDay),high=maxim(bloomDay);
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int check=possible(bloomDay,mid,m,k);
            if(check==1){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int possible(int[] arr ,int day,int m, int k){
        int c=0; int bloomday=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                c++;
            }else{
                bloomday+=(c/k);
                c=0;
            }
        }
        bloomday+=(c/k);
        if(bloomday>=m){
            return 1;
        }
        return 0;
    }
    public int maxim(int[] arr ){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(arr[i],max);
        }
        return max;
    }
    public int minim(int[] arr ){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min=Math.min(arr[i],min);
        }
        return min;
    }
}