class Solution {
    public int minChanges(int n, int k) {
        int ans=0;
        String a=Integer.toBinaryString(n);
        String ab=Integer.toBinaryString(k);
        while (a.length() < ab.length()) {
            a = "0" + a;
        }
        while (ab.length() < a.length()) {
            ab = "0" + ab;
        }
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) =='1' && ab.charAt(i)=='0'){
                ans++;
            }else if(a.charAt(i) =='0' && ab.charAt(i)=='1'){
                return -1;
            }
        }
        return ans;
    }
}