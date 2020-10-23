import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> result = new LinkedList<>();
        int len = asteroids.length;
        
        while(len-- > 0){
            for(int asteroid : asteroids){
                if(result.size() == 0) {
                    result.addLast(asteroid);
                    continue;
                }
                
                int pre = result.getLast();
                
                if(pre > 0 && asteroid < 0) {
                    int sum = pre + asteroid;
                    if(sum < 0){
                        result.removeLast();
                        result.addLast(asteroid);
                    } else if(sum == 0) result.removeLast();
                } else result.addLast(asteroid);
            }
            
            asteroids = result.stream().mapToInt(item -> item.intValue()).toArray();
            result = new LinkedList<>();
        }
        
        return asteroids;
    }
}
