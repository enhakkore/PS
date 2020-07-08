class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        for(int left = 0, right = 0 ; right < nums.length ; right++){

            int len = right - left + 1;
            int curSum = 0;
            for(int i = left ; i <= right ; i++){
                curSum += nums[i];
            }

            if(curSum >= s) return len;

            for(int i = left, j = right+1 ; j < nums.length ; i++, j++){
                curSum += nums[j];
                curSum -= nums[i];

                if(curSum >= s) return len;
            }
        }

        return 0;
    }
}
