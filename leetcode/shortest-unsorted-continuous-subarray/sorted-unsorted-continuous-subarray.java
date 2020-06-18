class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length <= 1) return 0;

        int left = -1, right = -2;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max, nums[i]);
            if(max > nums[i]){
                right = i;
            }
        }

        for(int i = nums.length - 1 ; i >= 0 ; i--){
            min = Math.min(min, nums[i]);
            if(min < nums[i]){
                left = i;
            }
        }

        return right - left + 1;
    }

//     public int findUnsortedSubarray(int[] nums) {
//         int[] sortedNums = Arrays.stream(nums).sorted().toArray();

//         int left = 0;
//         int right = nums.length-1;

//         while(left < nums.length && nums[left] == sortedNums[left]) left++;
//         while(right >= 0 && nums[right] == sortedNums[right]) right--;

//         int val = right - left + 1;
//         return val > 1 ? val : 0;
//     }

}
