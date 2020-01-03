import java.util.*;

class Solution {

    static ArrayList<Integer> found = new ArrayList<>();
    static int answer = 0;

    public boolean check(String value){

        boolean result = true;
        int subject = Integer.parseInt(value);

        if( subject <= 1 || (subject != 2 && subject % 2 == 0)) return false;

        for(int i = 3 ; i*i <= subject ; i += 2){
            if(subject % i == 0){
                result = false;
                break;
            }
        }

        if(result)
            found.add(subject);

        return result;
    }

    public void dfs(int limit, int current, String numbers, boolean[] visited, String value){
        value += numbers.charAt(current);

        if(value.length() == limit){
            int value2 = Integer.parseInt(value);
            if(!found.contains(value2))
                if(check(value)) {
                    answer++;
                }
            return;
        }

        for(int i = 0; i < numbers.length() ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(limit, i, numbers, visited, value);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        int n = numbers.length();

        for(int i = 1; i <= n ; i++){
            boolean[] visited = new boolean[n];
            for(int j = 0 ; j < n ; j++){
                visited[j] = true;
                dfs(i, j, numbers, visited, new String());
                visited[j] = false;
            }
        }

        return answer;
    }
}
