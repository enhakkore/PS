class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1 || k < 1 || t < 0) return false;

        int i = 0;

        do{
            int j = i+1;
            int limit = i+k;

            do{
                long diff;
                long a = nums[i];
                long b = nums[j];

                if(a <= b) diff = b-a;
                else diff = a-b;

                if(diff <= t) return true;

                j++;
            }while(j <= limit && j < nums.length);

            i++;
        }while(i < nums.length-1);

        return false;
    }
}
