class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
         Set<String> dictSet = new HashSet<>(dictionary);
        String[] sen = sentence.split(" ");
        for (int i = 0; i < sen.length; i++) {
            for (int j = 1; j <= sen[i].length(); j++) {
                String sub = sen[i].substring(0, j);
                if (dictSet.contains(sub)) {
                    sen[i] = sub;
                    break;
                }
            }
        }
        
        return String.join(" ", sen);
    }
}