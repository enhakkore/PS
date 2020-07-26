class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int num : nums){
            if(num < min){
                min = num;
                break;
            }
        }

        return min;
    }
}
