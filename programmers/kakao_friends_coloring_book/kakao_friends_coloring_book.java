import java.util.*;

class Solution {
    static int[] dr = { 0, 0, 1, -1};
    static int[] dc = { 1, -1, 0, 0};
    static int tmp_area = 0;
    static int M, N;

    public void check(int target, int r, int c, int[][] picture, boolean[][] visited){
        visited[r][c] = true;
        tmp_area++;

        for(int i = 0 ; i < 4 ; i++){
            int R = r + dr[i];
            int C = c + dc[i];
            if(R < M && R >= 0 && C < N && C >=0 )
                if(picture[R][C] == target && !visited[R][C]){
                    check(target, R, C, picture, visited);
                }
        }

        return;
    }

    public int[] solution(int m, int n, int[][] picture) {
        M = m; N = n;
        List<Integer> color = new ArrayList<>();
        TreeSet<Integer> area = new TreeSet<>();

        boolean[][] visited = new boolean[m][n];

        for(int r = 0 ; r < m ; r++){
            for(int c = 0 ; c < n ; c++){
                if(picture[r][c] != 0 && !visited[r][c]){
                    check(picture[r][c], r, c, picture, visited);
                    color.add(picture[r][c]);
                    area.add(tmp_area);
                    tmp_area = 0;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = color.size();
        answer[1] = area.last();

        return answer;

  }
}
