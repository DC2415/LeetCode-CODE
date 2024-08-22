class Solution {
    public int findComplement(int num) {
        String a=Integer.toBinaryString(num);
        int ans=0,j=0;
        for(int i=a.length()-1;i>=0;i--){
            if(a.charAt(i)=='0'){
                ans+=Math.pow(2,j);
            }
            j++;
        }
       System.out.println(a);
        return ans;
    }
}