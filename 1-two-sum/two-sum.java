class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        // Store [value, originalIndex]
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort based on values in ascending order
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left][0] + arr[right][0];

            if (sum == target) {
                return new int[] { arr[left][1], arr[right][1] };
            } else if (sum < target) {
                left++; // sum chota hai, toh left pointer ko aage badhao
            } else {
                right--; // sum bada hai, toh right pointer ko peeche laao
            }
        }

        return new int[] {};
    }
}