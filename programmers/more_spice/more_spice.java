import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> tmp = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        pq.addAll(tmp);

        int answer = 0;

        while(true){
            long count = pq.stream().count();
            long afterCount = pq.stream().filter( e -> e >= K).count();
            if( count == afterCount)
                break;

            if( count <= 1){
                answer = -1;
                break;
            } else {
                int a = pq.poll();
                int b = pq.poll();
                int c = a + (b*2);
                pq.add(c);
                answer++;
            }
        }

        return answer;
    }
}
