import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> info = new HashMap<>();

        for(int index = 0; index < nums.length ; index++){
            info.put(nums[index], index);
        }

        int[] answer = new int[2];
        for(int index = 0 ; index < nums.length ; index++){
            int tmp = target - nums[index];
            if(info.containsKey(tmp)){
                int index2 = info.get(tmp);
                if(index != index2){
                    if(index < index2){
                        answer[0] = index;
                        answer[1] = index2;
                    } else {
                        answer[0] = index2;
                        answer[1] = index;
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
