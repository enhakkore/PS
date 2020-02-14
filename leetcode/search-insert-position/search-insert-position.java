class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int index = 0 ; index < nums.length ; index++){
            if(nums[index] == target)
                return index;
            if(nums[index] > target)
                return index;
        }
        return nums.length;
    }
}
