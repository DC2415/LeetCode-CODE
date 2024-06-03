class Solution {
    public int appendCharacters(String s, String t) {
        int i=0,j=0,c=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                c++;
                i++;
                j++;
            }else{
                i++;
            }
        }
        return t.length()-c;
    }
}