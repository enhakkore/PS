class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length ; i++){
            boolean flag = true;
            for(int j = 0 ; j < nums.length ; j++){
                if(i != j && nums[i] == nums[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) return nums[i];
        }

        return 0;
    }
}
