// 효율성 테스크 통과

import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> tmp = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        pq.addAll(tmp);

        int answer = 0;

        while(true){
            Integer a = pq.poll();
            Integer b = pq.poll();
            if(b == null){
                if(a < K)
                    answer = -1;
                break;
            }

            if( a < K){
                Integer c = a + b*2;
                pq.add(c);
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
