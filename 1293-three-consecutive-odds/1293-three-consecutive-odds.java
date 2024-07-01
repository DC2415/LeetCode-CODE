class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int flag=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
                flag+=1;
            }else{
                flag=0;
            }
            if(flag==3){
                return true;
            }
        }
        return false;
    }
}