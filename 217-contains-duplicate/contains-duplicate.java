class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> SEEN = new HashSet<>();

        for(int num : nums){
            if(!SEEN.add(num)){
                return true;
            }
        }
        return false;
        
    }
}