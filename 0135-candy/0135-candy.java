class Solution {
    public int candy(int[] ratings) {
        int[] lf= new int[ratings.length];
        int[] rf=new int[ratings.length];
        lf[0]=1;rf[ratings.length-1]=1;

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                lf[i]=lf[i-1]+1;
            }else{
                lf[i]=1;
            }
        }
        for(int j=ratings.length-2;j>=0;j--){
            if(ratings[j]>ratings[j+1]){
                rf[j]=rf[j+1]+1;
            }else{
                rf[j]=1;
            }
        }
        int ans=0;
        for(int q=0;q<ratings.length;q++){
            ans+=Math.max(lf[q],rf[q]);
        }
        return ans;
    }
}