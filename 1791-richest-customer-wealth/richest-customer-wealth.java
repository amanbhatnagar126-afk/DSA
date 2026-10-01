class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int currentCustomerSum = 0;
            for (int bankAccount : customer) {
                currentCustomerSum += bankAccount;
            }
            maxWealth = Math.max(maxWealth, currentCustomerSum);
        }

        return maxWealth;
    }
}