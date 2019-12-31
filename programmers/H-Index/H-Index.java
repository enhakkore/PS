import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] ci = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(ci, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b.compareTo(a);
            }
        });

        int answer = -1;

        for(int i = 0 ; i < ci.length ; i++){
            if( i >= ci[i]){
                answer = i;
                break;
            }
        }

        if(answer < 0) answer = ci.length;

        return answer;
    }
}
