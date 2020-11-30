import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> stock = new HashSet<>();
        
        for(int i = 0 ; i < numbers.length - 1 ; i++){
            for(int j = i+1 ; j < numbers.length ; j++) {
                stock.add(numbers[i] + numbers[j]);
            }
        }
        
        return stock.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
