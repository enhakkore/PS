import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> info = new HashMap<>();

        for(String[] tmp : clothes){
            info.put(tmp[1], (Integer)info.getOrDefault(tmp[1], (Integer)0)+1);
        }

        int answer = 1;

        for(String key : info.keySet())
            answer *= (info.get(key)+1);

        return --answer;
    }
}
