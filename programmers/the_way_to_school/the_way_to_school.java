class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] area = new int[n][m];
        for(int[] water : puddles){
            area[water[1]-1][water[0]-1] = -1;
        }

        area[0][0] = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(area[i][j] != -1){
                    int tmp = 0;
                    if(i-1 >= 0 && area[i-1][j] != -1) {
                        tmp += area[i-1][j];
                    }

                    if(j-1 >= 0 && area[i][j-1] != -1){
                        tmp += area[i][j-1];
                    }

                    area[i][j] += tmp % 1000000007;
                }
            }
        }

        return area[n-1][m-1];
    }
}
