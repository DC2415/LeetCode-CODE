class Solution {
    public static int findPages(int[] arr, int n, int m) {
        // Write your code here.
        int low=maxim(arr,n);
        int high=sum(arr,n);
        if(m>n){
            return -1;
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int count=minpages(arr,n,mid);
            if(count>m){
                low=mid+1;
            }else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    public static int minpages(int[] arr ,int n ,int max){
        int countstud=1 ,pages=0;
        for(int i=0;i<n;i++){
            if(pages+arr[i]<=max){
                pages+=arr[i];
            }
            else{
                countstud+=1;
                pages=arr[i];
            }
        }
        return countstud;
    }
    public static int maxim(int[] arr, int n){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    
    public static int sum(int[] arr,int n){
        int max=0;
        for(int i=0;i<n;i++){
            max+=arr[i];
        }
        return max;
    }
    public int splitArray(int[] nums, int k) {
        return findPages(nums,nums.length,k);
    }
}