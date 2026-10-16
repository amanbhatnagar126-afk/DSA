class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        long MOD = 1000000007;

        long[] treeSum = new long[4 * n];
        long[] treeSq = new long[4 * n];
        long[] lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prevIndex = lastSeen.getOrDefault(val, -1);

            int updateL = prevIndex + 1;
            int updateR = i;

            // iterative / stack-based segment tree update range [updateL, updateR]
            updateRange(1, 0, n - 1, updateL, updateR, 1, treeSum, treeSq, lazy, MOD);

            totalSum = (totalSum + treeSq[1]) % MOD;
            lastSeen.put(val, i);
        }

        return (int) totalSum;
    }

    private void updateRange(int node, int start, int end, int l, int r, long val, 
                             long[] treeSum, long[] treeSq, long[] lazy, long MOD) {
        if (lazy[node] != 0) {
            long lazyVal = lazy[node];
            lazy[node] = 0;

            if (start != end) {
                int mid = (start + end) / 2;
                int left = 2 * node;
                int right = 2 * node + 1;

                applyNode(left, start, mid, lazyVal, treeSum, treeSq, lazy, MOD);
                applyNode(right, mid + 1, end, lazyVal, treeSum, treeSq, lazy, MOD);
            }
        }

        if (l <= start && end <= r) {
            applyNode(node, start, end, val, treeSum, treeSq, lazy, MOD);
            return;
        }

        int mid = (start + end) / 2;
        if (l <= mid) updateRange(2 * node, start, mid, l, r, val, treeSum, treeSq, lazy, MOD);
        if (r > mid) updateRange(2 * node + 1, mid + 1, end, l, r, val, treeSum, treeSq, lazy, MOD);

        treeSum[node] = (treeSum[2 * node] + treeSum[2 * node + 1]) % MOD;
        treeSq[node] = (treeSq[2 * node] + treeSq[2 * node + 1]) % MOD;
    }

    private void applyNode(int node, int start, int end, long val, 
                           long[] treeSum, long[] treeSq, long[] lazy, long MOD) {
        long len = end - start + 1;
        treeSq[node] = (treeSq[node] + 2 * val % MOD * treeSum[node] % MOD + val * val % MOD * len % MOD) % MOD;
        treeSum[node] = (treeSum[node] + val * len % MOD) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }
}