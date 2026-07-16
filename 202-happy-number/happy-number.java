class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = getNext(slow);          
            fast = getNext(getNext(fast)); 
        } while (slow != fast);
        
        return slow == 1;
    }
    
    private int getNext(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;
            totalSum += digit * digit;
            number /= 10;
        }
        return totalSum;
    }
}