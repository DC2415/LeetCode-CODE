import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge case: if s1 is longer than s2, s1 can't be a permutation of any substring of s2
        if (s1.length() > s2.length()) {
            return false;
        }

        // Step 1: Create a frequency map of characters in s1
        HashMap<Character, Integer> map = new HashMap<>();
        for (char a1 : s1.toCharArray()) {
            map.put(a1, map.getOrDefault(a1, 0) + 1);
        }

        // Step 2: Traverse s2 with a sliding window approach
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> temp = new HashMap<>(map); // Create a copy of the original map
            int l = 0;
            int r = i;

            // Check if the current substring is a permutation
            while (l < s1.length()) {
                char currentChar = s2.charAt(r);

                // If the current character is in the map and its count is greater than 0
                if (temp.containsKey(currentChar) && temp.get(currentChar) > 0) {
                    // Decrement the count of the character in the map
                    temp.put(currentChar, temp.get(currentChar) - 1);
                    l++; // Move the left pointer forward (process one character)
                    r++; // Move the right pointer forward
                } else {
                    // If the character is not in the map or has no remaining count, break
                    break;
                }
            }

            // If we've matched all characters of s1, return true
            if (l == s1.length()) {
                return true;
            }
        }

        // If no permutation of s1 was found in s2, return false
        return false;
    }
}
