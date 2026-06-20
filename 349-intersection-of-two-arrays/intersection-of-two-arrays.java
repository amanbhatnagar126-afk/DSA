class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> resultList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                i++;
            }
            else if (nums1[i] > nums2[j]){
                j++;
            }
            else{
                if(resultList.isEmpty() || resultList.get(resultList.size() - 1) != nums1[i]){
                    resultList.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[]result = new int[resultList.size()];
        for(int k = 0; k < resultList.size(); k++){
            result[k] = resultList.get(k);
        }
        return result;
    }
}