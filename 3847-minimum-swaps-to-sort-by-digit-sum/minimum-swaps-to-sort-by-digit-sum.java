class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // pair: [digitSum, value, originalIndex]
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            int sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            arr[i][0] = sum;
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }

        // custom sort: compare digit sum first, then number value
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // cycle detection for minimum swaps
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            int cycleSize = 0;
            int curr = i;

            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr][2];
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}