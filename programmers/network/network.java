class Solution {
    static int ans = 0;
    static boolean[] visited;

    public void sol1(int index, int n, int[][] computers){

        visited[index] = true;

        for(int i = 0; i < n ; i++){
            if(visited[i] != true && computers[index][i] == 1) {
                sol1(i, n, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(visited[i] != true){
                ans++;
                sol1(i, n, computers);
            }
        }

        return ans;
    }
}
