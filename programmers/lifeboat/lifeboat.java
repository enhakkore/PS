import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        for(int i = people.length - 1, j = 0; i >= 0 ; i--){
            if(people[j] <= limit-people[i]) j++;

            answer++;

            if(j >= i) break;
        }

        return answer;
    }
}
