class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int l = 0;
        int r = height.length-1;

        while(l < r){
            int width = r - l;
            int currentHeight = Math.min(height[l], height[r]);

            int currentWater = width * currentHeight;

            maxWater = Math.max(currentWater, maxWater);

            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxWater;
        
    }
}