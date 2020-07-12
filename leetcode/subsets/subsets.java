class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();

        long limit = (long)Math.pow(2, nums.length);
        for(long base = 0L; base < limit ; base++){

            List<Integer> subSet = new ArrayList<>();
            for(int i = 0; i < nums.length ; i++){
                if((base & (1 << i)) > 0){
                    subSet.add(nums[i]);
                }
            }
            subSets.add(subSet);
        }

        return subSets;
    }
}
