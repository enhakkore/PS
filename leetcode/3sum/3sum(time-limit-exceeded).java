class Solution {
    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length-2; i++){
            for(int j = i+1 ; j < nums.length-1; j++){
                long sum = (long)nums[i]+nums[j];
                for(int k = j+1; k < nums.length ; k++){
                    if(sum + nums[k] == 0L){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
