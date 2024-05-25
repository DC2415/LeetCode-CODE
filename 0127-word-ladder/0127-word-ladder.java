class pair{
    String word;
    int step;
    public pair(String a,int b){
        word=a;
        step=b;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>();
        for(String a: wordList){
            st.add(a);
        }
       // st.add(beginWord);
        Queue<pair> qu=new LinkedList<>();
        qu.add(new pair(beginWord,1));
        st.remove(beginWord);
        while(! qu.isEmpty()){
            pair a=qu.poll();
            String word=a.word;
            int s=a.step;
            if(word.equals(endWord)){
                return s;
            }
            for(int i=0;i<word.length();i++){
                for(char j='a';j<='z';j++){
                    char[] rep=word.toCharArray();
                    rep[i]=j;
                    String repWord=new String(rep);
                    if(st.contains(repWord)){
                        qu.add(new pair(repWord,s+1));
                        st.remove(repWord);
                    }
                }
            }
        }
        return 0;
    }
}