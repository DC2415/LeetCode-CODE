import java.util.HashSet;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low =1;
        int high = position[position.length-1]-position[0];
       int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPlace(position,m,mid)){
                low=mid+1;
            }else{
                ans=Math.min(ans,high);
                high=mid-1;
            }
        }
        return high;
        
    }
    public boolean canPlace(int[] pos,int m,int dis){
        int c=1;
        int lasp=pos[0];
        for(int i=1;i<pos.length;i++){
            if(pos[i]-lasp>=dis){
                c++;
                lasp=pos[i];
            }
            if(c>=m){
                return true;
            }
        }
        return false;
    }

}
