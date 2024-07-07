class Solution {
    public int numWaterBottles(int nb, int ne) {
        int ans = nb;
        while(nb>=ne){
            int b=nb/ne;
            int r= nb%ne;
            ans+=b;
            nb=b+r;
        }
        return ans;
    }
}