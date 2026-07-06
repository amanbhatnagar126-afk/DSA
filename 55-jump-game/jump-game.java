class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int targetIndex = nums.length-1;

        for(int i = 0; i <= targetIndex; i++){
            if(i > maxReach){
                return false;
            }
            
            maxReach = Math.max(maxReach, i + nums[i]);

            if(maxReach >= targetIndex){
                return true;
            }
        }
        return false;
        
    }
}