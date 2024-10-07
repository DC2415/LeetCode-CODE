class Solution {
    public int minLength(String s) {
        if(s.indexOf("AB") == -1 && s.indexOf("CD")==-1){
            return s.length();
        }
        StringBuilder ss=new StringBuilder(s);
        while(ss.indexOf("AB") !=-1  || ss.indexOf("CD")!=-1){
            int a=ss.indexOf("AB");
            if(a!=-1){
            ss.delete(a,a+2);}
            int c=ss.indexOf("CD");
            if(c!=-1){
            ss.delete(c,c+2);}
        }
        return ss.length();
    }
}