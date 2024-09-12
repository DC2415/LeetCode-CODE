class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character>  am=new HashSet();
        for(int i=0;i<allowed.length();i++){
            am.add(allowed.charAt(i));
        }
    int ans=0;
        for(int i=0;i<words.length;i++){
            String x=words[i];
            int flag=1;
            for(int j=0;j<x.length();j++){
                if(!am.contains(x.charAt(j))){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                ans+=1;
            }
        }
        return ans;
    }
}