class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int index = 0;
        for(int i = 0 ; i < nums.length ; ){
            if(i == nums.length-1){
                ans[index++] = nums[i];
            }
            else if(nums[i] != nums[i+1]){
                ans[index++] = nums[i];
                i++;
            }
            else
                i += 2;

            if(index == 2) break;
        }

        return ans;
    }
}
