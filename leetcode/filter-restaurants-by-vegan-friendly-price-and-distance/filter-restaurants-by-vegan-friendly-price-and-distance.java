import java.util.*;
import java.util.stream.*;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        final int vf = veganFriendly;
        final int mp = maxPrice;
        final int md = maxDistance;

        return Arrays.stream(restaurants)
                        .filter(a ->  vf <= a[2])
                        .filter(a1 -> a1[3] <= mp && a1[4] <= md)
                        .sorted((b1, b2) -> {
                            int val =  b2[1]-b1[1];
                            if(val == 0) return b2[0]-b1[0];
                            return val;
                        })
                        .map(c -> Integer.valueOf(c[0]))
                        .collect(Collectors.toList());
    }
}
