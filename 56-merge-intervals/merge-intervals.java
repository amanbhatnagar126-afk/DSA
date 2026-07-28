class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(visited[i]) continue;

            int start = intervals[i][0];
            int end = intervals[i][1];

            for(int j = i + 1; j < n; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end, intervals[j][1]);
                    visited[j] = true;
                }
                else{
                    break;
                }
            }
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][]);
    }
}