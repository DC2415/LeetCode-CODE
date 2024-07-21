class Solution {
    public boolean doesAliceWin(String s) {
        HashSet<Character> ds =new HashSet();
        ds.add('a');
        ds.add('u');
        ds.add('i');
        ds.add('o');
        ds.add('e');
        int i=0;
        while(i<s.length()){
            if(ds.contains(s.charAt(i))){
                return true;
            }
            i++;
        }
        return false;
        
    }
}