class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                if(j <= i ) j = i+1;
                for(; j < nums.length ; j++){
                    if(nums[j] != 0){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
            }

            if(j >= nums.length-1) break;
        }
    }
}
