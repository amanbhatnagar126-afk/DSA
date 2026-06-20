class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         boolean[] seen = new boolean[1001];
        
        // Mark the numbers present in nums1
        for (int num : nums1) {
            seen[num] = true;
        }
        
        // Temporary array to store results
        int[] tempResult = new int[1001];
        int count = 0;
        
        // Check nums2 against our boolean array
        for (int num : nums2) {
            if (seen[num]) {
                tempResult[count++] = num;
                // Set to false immediately so we don't add duplicates
                seen[num] = false; 
            }
        }
        
        // Copy exactly 'count' elements to the final sized array
        int[] finalResult = new int[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = tempResult[i];
        }
        
        return finalResult;
        
    }
}