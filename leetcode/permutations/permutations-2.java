class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permutation(nums, 0, nums.length);
        return ans;
    }

    public void permutation(int[] nums, int index, int size){
        if(index == size){
            List<Integer> mid = new ArrayList<>(){
                {
                    for(int n : nums) add(n);
                }
            };

            ans.add(mid);
            return;
        }

        for(int i = index ; i < size ; i++){
            swap(nums, index, i);
            permutation(nums, index+1, size);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int from, int to){
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
