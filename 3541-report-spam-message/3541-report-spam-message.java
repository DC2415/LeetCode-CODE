class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> ds=new HashSet();
        for(String a : bannedWords){
            ds.add(a);
        }
        int c=0;
        for(String in : message){
            if(ds.contains(in)){
                c+=1;
            }
            if(c>=2){
                return true;
            }
        }
        return false;
    }
}