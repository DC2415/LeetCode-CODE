// class Solution {
//     public String compressedString(String word) {
//         Map<Character,Integer> map=new LinkedHashMap();
//         StringBuilder ans= new StringBuilder();
//         for(int i=0;i<word.length();i++){
//             char a=word.charAt(i);
//             if(map.containsKey(a)){
//                 map.put(a,map.get(a)+1);
//             }else{
//                 map.put(a,1);
//             }
//         }
//         for(char s : map.keySet()){
//             int v =map.get(s);
//             while(v>9){
//                 ans.append(9);
//                 ans.append(s);
//                 v-=9;
//             }
//             ans.append(v);
//             ans.append(s);
//         }
//         return ans.toString();
//     }
// }

class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int cnt = 1, n = word.length();
        char ch = word.charAt(0);
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == ch && cnt < 9) {
                cnt++;
            } else {
                comp.append(cnt).append(ch);
                ch = word.charAt(i);
                cnt = 1;
            }
        }
        comp.append(cnt).append(ch);
        return comp.toString();
    }
}