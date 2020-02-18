class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return Integer.MIN_VALUE;
        return maxSum(nums, 0, nums.length-1);
    }

    public int maxSum(int[] nums, int left, int right){
        if(left == right){
            return nums[right];
        }

        int mid = left+(right-left)/2;

        int leftMax = maxSum(nums, left, mid);
        int rightMax = maxSum(nums, mid+1, right);
        int crossMax = crossMax(nums, left, mid, right);

        return Math.max(leftMax, Math.max(rightMax, crossMax));
    }

    public int crossMax(int[] nums, int left, int mid, int right){
        int sum = 0;
        int leftMax = Integer.MIN_VALUE;
        for(int i = mid; i >= left ; i--){
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        sum = 0;
        int rightMax = Integer.MIN_VALUE;
        for(int i = mid+1; i <= right ; i++){
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax+rightMax;
    }
}
