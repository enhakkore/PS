class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length-1;
        digits[len] += 1;

        if(digits[len] < 10) return digits;

        int quo = digits[len] / 10;
        digits[len--] %= 10;

        while(quo > 0 && len >= 0){
            digits[len] += quo;
            quo = digits[len] / 10;
            digits[len--] %= 10;
        }

        if(quo > 0){
            int[] tmp = new int[digits.length+1];
            tmp[0] = quo;
            for(int i = 0 ; i < digits.length ; i++){
                tmp[i+1] = digits[i];
            }
            digits = tmp;
        }

        return digits;
    }
}
