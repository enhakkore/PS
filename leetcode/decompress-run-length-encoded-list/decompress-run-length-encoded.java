import java.util.*;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; 2*i+1 < nums.length ; i++){
            int freq = nums[2*i];
            int val = nums[2*i+1];

            while(freq-- > 0){
                ans.add(val);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
