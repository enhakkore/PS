import java.util.*;
import java.util.stream.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        final int max = Arrays.stream(candies).max().getAsInt();
        final int ex = extraCandies;

        return Arrays.stream(candies).map(c -> {
            if(c != max) return c+ex;
            return c;
        }).mapToObj(d -> {
            if(d >= max) return Boolean.TRUE;
            else return Boolean.FALSE;
        }).collect(Collectors.toList());
    }
}
