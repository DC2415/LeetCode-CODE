class Solution {
    public int minBitFlips(int start, int goal) {
        String ans= Integer.toBinaryString(start^goal);
        int c=0;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='1'){
                c++;
            }
        }
        return c;
    }
}