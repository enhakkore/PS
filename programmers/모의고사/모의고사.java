import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        long one_count = IntStream.range(0, answers.length)
            .filter(i -> answers[i] == one[i % one.length])
            .count();

        long two_count = IntStream.range(0, answers.length)
            .filter(i -> answers[i] == two[i % two.length])
            .count();

        long three_count = IntStream.range(0, answers.length)
            .filter(i -> answers[i] == three[i % three.length])
            .count();

        long max = Math.max(one_count, Math.max(two_count, three_count));
        if(max == 0) return new int[0];

        List<Integer> answer = new ArrayList<>();
        if(one_count == max) answer.add(1);
        if(two_count == max) answer.add(2);
        if(three_count == max) answer.add(3);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
