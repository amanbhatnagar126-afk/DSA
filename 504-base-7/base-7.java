class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";

        boolean isNegative = num < 0;
        num = Math.abs(num);

        String result = "";

        while(num > 0){
            int remainder = num % 7;
            result = remainder + result;
            num = num / 7;
        }
        if(isNegative){
            result = "-" + result;
        }
        return result;
    }
}