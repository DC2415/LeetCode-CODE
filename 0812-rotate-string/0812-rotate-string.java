class Solution {
    public boolean rotateString(String s, String goal) {
        
        StringBuilder ans = new StringBuilder(s);

        for(int i=0; i<s.length(); i++){

            char ch = ans.charAt(0);
            ans.deleteCharAt(0);

            ans.append(ch);

            if(ans.toString().equals(goal)) return true;
        }

        return false;
    }
}