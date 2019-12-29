import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] clone = new String[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
            clone[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(clone, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });

        /*Arrays.sort(clone, (o1, o2) -> (o2+o1).compareTo(o1+o2)); */

        if(clone[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();
        for(int i = 0 ; i < clone.length ; i++){
            answer.append(clone[i]);
        }
        return answer.toString();
    }
}
