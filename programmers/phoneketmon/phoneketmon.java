import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int leng = nums.length/2;
        long count = Arrays.stream(nums).distinct().count();

        return count - leng <= 0 ? (int)count : leng;
    }
}
