class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length ; i++){
            ans[i] = binarySearch(sortedNums, nums[i]);
        }

        return ans;
    }

    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2 ;

            if(nums[mid] >= target){
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}
