import java.util.*;

class Solution {
    public int check(int[] one, int[] answers){
        int ans = 0 ;
        for(int i = 0 ; i < answers.length ; i++){
            int index = i % one.length;
            if( answers[i] == one[index])
                ans++;
        }

        return ans;
    }

    public int[] solution(int[] answers) {
        int[][] student = {{1, 2, 3, 4, 5},
                          {2, 1, 2, 3, 2, 4, 2, 5},
                           {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        HashMap<Integer, Integer> ans = new HashMap<>();

        int score = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < 3 ; i++){
            score = check(student[i], answers);
            if(score > 0) {
                ans.put(i+1, score);
                max = Math.max(max, score);
            }
        }

        List<Integer> ans0 = new ArrayList<>(ans.keySet());

        Collections.sort(ans0, (o1, o2) -> {
            int a = ans.get(o1);
            int b = ans.get(o2);

            if(a == b) return o1.compareTo(o2);
            else return b-a;
        });

        final int _max = max;
        int[] answer = ans0.stream().mapToInt(Integer::intValue).filter(w -> ans.get(w) == _max).toArray();

        return answer;
    }
}
