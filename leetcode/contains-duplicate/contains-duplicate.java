import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> info = new HashSet<>();
        for(int num : nums){
            if(!info.add(num)) return true;
        }

        return false;
    }
}
