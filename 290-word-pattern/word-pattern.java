import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashSet<String> usedWords = new HashSet<>();
        
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];

            if(charToWord.containsKey(c)){
                if(!charToWord.get(c).equals(word)){
                    return false;
                }
            }
            else{
                if(usedWords.contains(word)){
                    return false;
                }
                charToWord.put(c, word);
                usedWords.add(word);
            }
        }
        return true;
    }
}