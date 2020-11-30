import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        participant = Stream.of(participant).sorted().toArray(String[]::new);
        completion = Stream.of(completion).sorted().toArray(String[]::new);

        int i;
        for(i = 0 ; i < completion.length ; i++ ){
            if(!completion[i].equals(participant[i])) return participant[i];
        }

        return participant[i];
    }
}
