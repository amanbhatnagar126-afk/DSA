class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        
        // 1. Reverse the entire character array
        reverse(a, 0, n - 1);
        
        // 2. Reverse each individual word within the reversed array
        reverseWords(a, n);
        
        // 3. Clean up the messy spaces and return the final string
        return cleanSpaces(a, n);
        
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
    
    // Find boundaries of each word and reverse them back to normal
    private void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || (i < n && a[i] == ' ')) i++; // Skip spaces to find start of word
            while (j < i || (j < n && a[j] != ' ')) j++; // Skip characters to find end of word
            reverse(a, i, j - 1); // Reverse the word back to normal direction
        }
    }
    
    // Shift characters left to eliminate multiple spaces, leading, and trailing spaces
    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // Skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // Keep characters
            while (j < n && a[j] == ' ') j++;             // Skip trailing spaces
            if (j < n) a[i++] = ' ';                      // Keep exactly one space between words
        }
        return new String(a, 0, i);
    }
}