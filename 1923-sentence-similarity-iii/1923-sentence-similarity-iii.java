class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String s, b;

        // Determine which sentence is shorter and which is longer
        if (sentence1.length() < sentence2.length()) {
            s = sentence1;
            b = sentence2;
        } else {
            s = sentence2;
            b = sentence1;
        }
        
        // Split the sentences into words
        String[] sm = s.split(" ");
        String[] bg = b.split(" ");
        
        int i = 0, j = sm.length - 1;
        int k = 0, l = bg.length - 1;

        // Compare words from the start
        while (i < sm.length && k < bg.length && sm[i].equals(bg[k])) {
            i++;
            k++;
        }

        // Compare words from the end
        while (i <= j && l >= k && sm[j].equals(bg[l])) {
            j--;
            l--;
        }

        // If all words from the shorter sentence match as prefix or suffix
        return i > j;
    }
}
