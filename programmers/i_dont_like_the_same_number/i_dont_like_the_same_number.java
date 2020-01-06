import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for(int tmp : arr){
            if(tmp != list.get(list.size()-1)){
                list.add(tmp);
            }
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
	}
}
