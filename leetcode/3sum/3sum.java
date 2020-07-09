class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, int[]> hashMap = new HashMap<>();

        if(len < 3) return result;

        Arrays.sort(nums);

        for(int i = 0 ; i < len -2 ; i++){
            if(nums[i] > 0) break;

            hashMap.clear();

            if(i == 0 || nums[i] > nums[i-1]){
                for(int j = i+1 ; j < len ; j++){
                    if(hashMap.containsKey(nums[j])){
                        List<Integer> elem = new ArrayList<>(3);

                        elem.add(hashMap.get(nums[j])[0]);
                        elem.add(hashMap.get(nums[j])[1]);
                        elem.add(nums[j]);

                        result.add(elem);

                        while(j < (len - 1) && nums[j] == nums[j+1]) j++;
                    } else {
                        int[] temp = {nums[i], nums[j]};
                        hashMap.put(0-(nums[i]+nums[j]), temp);
                    }
                }
            }
        }

        return result;
    }
}
