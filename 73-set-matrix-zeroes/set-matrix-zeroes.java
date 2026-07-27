class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rowMarker = new boolean[m];
        boolean[] colMarker = new boolean[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rowMarker[i] = true;
                    colMarker[j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rowMarker[i] || colMarker[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}