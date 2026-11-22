class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        int l = 0;
        int r = n - 1;
        int pos = n - 1;

        while(l <= r){
            int leftsq = nums[l] * nums[l];
            int rightsq = nums[r] * nums[r];

            if(leftsq > rightsq){
                res[pos] = leftsq;
                l++;
            }else{
                res[pos] = rightsq;
                r--;
            }
            pos--;
        }
        return res;
    }
}