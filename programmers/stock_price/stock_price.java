import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        ArrayDeque<Integer> ans = new ArrayDeque<>();

        for(int i = 0; i < prices.length ; i++){
            int subject = prices[i];
            int days = 0;
            for(int j = i + 1; j < prices.length ; j++){
                if(prices[j] >= subject)
                    days++;
                else {
                    days++;
                    break;
                }
            }
            ans.addLast(days);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
