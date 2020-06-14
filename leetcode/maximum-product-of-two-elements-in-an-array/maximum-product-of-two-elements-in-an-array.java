class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
            } else if(nums[i] > max2){
                max2 = nums[i];
            }
        }

        return --max1 * --max2;
    }

//     public int maxProduct(int[] nums) {
//         int max = 0;
//         for(int i = 0 ; i < nums.length-1 ; i++){
//             for(int j = i+1 ; j < nums.length ; j++){
//                 max = Math.max(max, (nums[i]-1)*(nums[j]-1));
//             }
//         }

//         return max;
//     }
}
