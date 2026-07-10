class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> SEEN = new HashSet<>();

        for(int num : nums){
            if(SEEN.contains(num)){
                return true;
            }
            SEEN.add(num);
        }
        return false;
        
    }
}