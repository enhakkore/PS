class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        int i = nums.length;
        for(int j = 0, t = 0; t < nums.length && j < nums.length ; t++){
            if(nums[j] == val){
                for(int k = j; k < nums.length-1 ; k++)
                    nums[k] = nums[k+1];
                i--;
            } else j++;
        }

        return i;
    }
}
