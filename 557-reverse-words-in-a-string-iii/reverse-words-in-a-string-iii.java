class Solution {
    public String reverseWords(String s) {
        String[] word = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < word.length; i++){
            StringBuilder reverseword = new StringBuilder(word[i]);
            result.append(reverseword.reverse());
            if(i < word.length - 1){
                result.append(" ");
            }
        }
        return result.toString();
    }
}