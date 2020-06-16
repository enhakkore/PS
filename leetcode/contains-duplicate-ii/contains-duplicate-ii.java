import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> info = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            List<Integer> indies = info.getOrDefault(nums[i], new ArrayList<>());
            indies.add(i);
            info.put(nums[i], indies);
        }

        for(Integer key : info.keySet()){
            List<Integer> cur = info.get(key);
            for(int i = 0 ; i < cur.size()-1 ; i++){
                if(Math.abs(cur.get(i)-cur.get(i+1)) <= k) return true;
            }
        }

        return false;
    }
}
