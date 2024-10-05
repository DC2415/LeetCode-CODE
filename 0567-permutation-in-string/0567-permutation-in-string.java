import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char a1 : s1.toCharArray()) {
            map.put(a1, map.getOrDefault(a1, 0) + 1);
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> temp = new HashMap<>(map); 
            int l = 0;
            int r = i;
            while (l < s1.length()) {
                char currentChar = s2.charAt(r);
                if (temp.containsKey(currentChar) && temp.get(currentChar) > 0) {
                    temp.put(currentChar, temp.get(currentChar) - 1);
                    l++; 
                    r++; 
                } else {
                    
                    break;
                }
            }
            if (l == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
