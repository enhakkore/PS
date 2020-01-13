import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int answer = 0;

        deq.addLast(1);
        visited[1] = true;
        ArrayDeque<Integer> mid = new ArrayDeque<>();
        while(!deq.isEmpty()){
            while(!deq.isEmpty()){
                int node = deq.removeFirst();

                for(int[] vertex : edge){
                    if(vertex[0] == node && !visited[vertex[1]]){
                        mid.addLast(vertex[1]);
                        visited[vertex[1]] = true;
                    }
                    else if(vertex[1] == node && !visited[vertex[0]]){
                        mid.addLast(vertex[0]);
                        visited[vertex[0]] = true;
                    }
                }
            }

            if(!mid.isEmpty()) answer = mid.size();
            deq.addAll(mid);
            mid.clear();
        }

        return answer;
    }
}
